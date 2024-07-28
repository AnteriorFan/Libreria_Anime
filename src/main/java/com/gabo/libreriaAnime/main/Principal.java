package com.gabo.libreriaAnime.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabo.libreriaAnime.dto.serie.infoSerie.Datos;
import com.gabo.libreriaAnime.dto.serie.infoSerie.DatosAnime;
import com.gabo.libreriaAnime.model.Anime.AnimeSerie;
import com.gabo.libreriaAnime.service.ConsumoAPI;
import com.gabo.libreriaAnime.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;
@Component
public class Principal {
    private final Scanner teclado;
    private  final ConvierteDatos convierteDatos;
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    private final  String URL_BASE =  "https://api.jikan.moe/v4/anime?q=";
    @Autowired
    public Principal(ObjectMapper objectMapper) {
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
                    \n
                    """;

            System.out.println(menu);
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc){
                case 1:
                    System.out.println("\n ->> NOMBRE DEL ANIME <<-\n");
                    String tituloAnime = teclado.nextLine();
                    String json = String.valueOf(consumoApi.obtenerDatos("https://api.jikan.moe/v4/anime?q=" + tituloAnime.replace(" ", "%20")));
                    Datos datos = convierteDatos.obtenerDatos(json, Datos.class);
//                    System.out.println(datos);
//                    Optional<DatosAnime> datosAnime = datos.resultados().stream().filter(s -> s.titulo().toUpperCase().contains(tituloAnime.toUpperCase()))
//                            .findFirst();
                    Optional<DatosAnime> datosAnime = datos.resultados().stream().filter(s -> s.titulo().toUpperCase().contains(tituloAnime.toUpperCase()))
                            .findFirst();
                    if (datosAnime.isPresent()){
                        System.out.println("kjonl sfdagj kblsfd");
                        System.out.println(datosAnime.get());
                    }else {
                        System.out.println("No se encontró o fallo");
                    }
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


        //return datos != null && datos.resultados() != null && !datos.resultados().isEmpty() ? datos.resultados().get(0) : null;
         System.out.println(datos);
         return null;
    }

    private void buscarAnime() {
        DatosAnime datos = this.getDatosSerie();

    }
}
