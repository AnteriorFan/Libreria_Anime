package com.gabo.libreriaAnime.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabo.libreriaAnime.dto.serie.infoSerie.Datos;
import com.gabo.libreriaAnime.dto.serie.infoSerie.DatosAnime;
import com.gabo.libreriaAnime.dto.serie.infoSerie.Genero;
import com.gabo.libreriaAnime.model.Anime.*;
import com.gabo.libreriaAnime.repository.GeneroRepository;
import com.gabo.libreriaAnime.repository.SerieRepository;
import com.gabo.libreriaAnime.service.ConsumoAPI;
import com.gabo.libreriaAnime.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Principal {
    private final Scanner teclado;
    private  final ConvierteDatos convierteDatos;
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    private final  String URL_BASE =  "https://api.jikan.moe/v4/anime?q=";
    private final SerieRepository repository;
    private final GeneroRepository generoRepository;
    private List<AnimeSerie> a;

    // Uso de @Autowired facilita la gestión de depedencias por medio del contructor
    @Autowired
    public Principal(ObjectMapper objectMapper, SerieRepository repository, GeneroRepository generoRepository) {
        this.repository = repository;
        this.generoRepository = generoRepository;
        this.teclado = new Scanner(System.in);
        this.convierteDatos = new ConvierteDatos(objectMapper);
    }


    public void main(){
        System.out.println("Que serie buscar");
        var opc = -1;

        while (opc != 0){
            var menu = """
                    \n
                    1 ->> Buscar Anime
                    2 ->> Buscar Episodios
                    3 ->> Mostrar series buscados
                    4 ->> Buscar Series por Genero
                    \n
                    """;

            System.out.println(menu);
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc){
                case 1:
                    buscarAnime();
//                    System.out.println("\n ->> NOMBRE DEL ANIME <<-\n");
//                    String tituloAnime = teclado.nextLine();
//                    String json = String.valueOf(consumoApi.obtenerDatos("https://api.jikan.moe/v4/anime?q=" + tituloAnime.replace(" ", "%20")));
//                    Datos datos = convierteDatos.obtenerDatos(json, Datos.class);
////                    System.out.println(datos);
////                    Optional<DatosAnime> datosAnime = datos.resultados().stream().filter(s -> s.titulo().toUpperCase().contains(tituloAnime.toUpperCase()))
////                            .findFirst();
//                    Optional<DatosAnime> datosAnime = datos.resultados().stream().filter(s -> s.titulo().toUpperCase().contains(tituloAnime.toUpperCase()))
//                            .findFirst();
//                    if (datosAnime.isPresent()){
//                        System.out.println("kjonl sfdagj kblsfd");
//                        System.out.println(datosAnime.get());
//                    }else {
//                        System.out.println("No se encontró o fallo");
//                    }b
                    break;
                case 2:
                    buscarEpisodio();
                    break;
                case 3:
                    showSFound();
                    break;

                case 4:
                    foundSGenere();
                    break;
                case 0:
                    System.out.println("Cerrando aplicación ...");
                    break;
                default:
                    System.out.println("No existe");
                    break;
            }
        }
    }

    private DatosAnime getDatosSerie(){
        System.out.println("\n ->> NOMBRE DEL ANIME <<-\n");
        String tituloAnime = teclado.nextLine();
        String json = String.valueOf(consumoApi.obtenerDatos("https://api.jikan.moe/v4/anime?q=" + tituloAnime.replace(" ", "%20")));
        Datos datos = convierteDatos.obtenerDatos(json, Datos.class);

        return datos != null && datos.resultados() != null && !datos.resultados().isEmpty() ? datos.resultados().get(0) : null;
    }

    //BUSCA LA SERIE Y HACE EL PROCEDIMIENTO DE GUARAS EN LA BASE DE DATOS
    private void buscarAnime() {
        DatosAnime datos = this.getDatosSerie();
        if (datos != null){

            if (repository.existsByTitulo(datos.titulo())){
                System.out.println("Este ya fue registrado" +
                        "\n" + datos);
                return;
            }

            // Crea y guarda los generos
            List<Categoria> g = datos.genero().stream().map(dg ->{
                return new Categoria(Genero.fromString(dg.generoAnime()));
            }).collect(Collectors.toList());
            this.generoRepository.saveAll(g);

            //Instancia de Anime Serie
            AnimeSerie aS = new AnimeSerie(datos);

            // Creación y Asignación de Imágenes
//            List<Imagenes> m = datos.images().stream().map(img -> new Imagenes(img)).collect(Collectors.toList());
            Imagenes ima = new Imagenes(datos.images().formato());
            aS.setImages(ima);

            // Creación y Asignación de Videos
            Videos video = new Videos(datos.urlVideo());
            video.setAnime(aS);
            aS.setUrlVideo(video);

            // Creación y Asignación de Fechas
            Fechas fechas = new Fechas(datos.fecha());
            fechas.setAnime(aS);
            aS.setFecha(Collections.singletonList(fechas));

            // Creación y Asignación de Productores
            List<Productores> productores = datos.productores().stream().map(p -> new Productores(p)).collect(Collectors.toList());
            productores.forEach(p -> p.setAnime(aS));
            aS.setProductores(productores);

            // Creación y Asignación de Licenciados
            List<Licenciado> licenciados = datos.licenciado().stream().map(l -> new Licenciado(l)).collect(Collectors.toList());
            licenciados.forEach(l -> l.setAnime(aS));
           aS.setLicenciado(licenciados);

            // Creación y Asignación de Studios
            List<Studios> estudios = datos.studio().stream().map(s -> new Studios(s)).collect(Collectors.toList());
            estudios.forEach(s -> s.setAnime(aS));
            aS.setStudio(estudios);

            aS.setGenero(g);
            this.repository.save(aS);
            System.out.println(datos);
        }else {
            System.out.println("No se encontraron los resultados");
        }
    }

    //BUSCA LOS EPISODIOS POR MEDIO DE LAS SERIES BUSCADAS
    private void buscarEpisodio() {

    }

    //DEVUELVE LAS SERIES QUE FUERON BUSCADAS Y GUARDADAS POR LA BASE DE DATOS
    private void showSFound(){
        List<AnimeSerie> series = repository.findAll();
        if (series.isEmpty()) {
            System.out.println("No hay series registradas.");
            return;
        }
        // Ordenar por género
        series.stream()
                .sorted(Comparator.comparing(anime ->
                        anime.getGenero() != null && !anime.getGenero().isEmpty()
                                ? anime.getGenero().get(0).toString() : ""))
                .forEach(System.out::println);
    }

    //BUSQUEDA DE SERIES POR GENERO
    public void foundSGenere() {
        System.out.println("Escribe el género/categoría de la serie");
        String genero = teclado.nextLine();
        Genero categoria;

        //Usa un try-catch para buscar los genero y so no encuantra el genero saldra un mesnaje
        try {
            categoria = Genero.fromEspanol(genero);
        } catch (IllegalArgumentException e) {
            try {
                categoria = Genero.fromString(genero);
            } catch (IllegalArgumentException ex) {
                System.out.println("Categoría no encontrada.");
                return;
            }
        }

        // Se crea una lista para almacenar las series buscadas
        List<AnimeSerie> animes = repository.findByCategoriaGenero(categoria);
        //En caso de no encontrar el género o la serie que contenga ese género procede a:
        if (animes.isEmpty()) {
            System.out.println("No hay Series Con ese Genero");
        } else {
            System.out.println("Categoría: " + genero);
            animes.forEach(an -> System.out.println("\n|----------------------------------------------|\n" + an.getImages() + "\n" + an.getTitulo()));
        }
    }

}
