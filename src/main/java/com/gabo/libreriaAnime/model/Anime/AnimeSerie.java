package com.gabo.libreriaAnime.model.Anime;

import com.gabo.libreriaAnime.dto.serie.infoSerie.*;

import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(
        name = "animeSeries"
)
public class AnimeSerie {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long Id;
    private Integer idAnime;
    @OneToOne(mappedBy = "anime", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  Imagenes images;
    @OneToOne(mappedBy = "anime", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Videos urlVideo;
    @Column(
            unique = true
    )
    private  String titulo;

    private String tituloIngles;

    private String tituloJapones;

    private String tipo;

    private String fuente;

    private Integer nEpisodios;

    private String status;
    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Fechas> fecha;

    private String duracion;

    private String rating;

    private  Double puntaje;
    @Column(
            columnDefinition = "TEXT"
    )
    private String sinopsis;

    private String temporada;

    private Integer ano;
    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Productores> productores;
    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Licenciado> licenciado;
    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Studios> studio;
    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "anime_genero",
            joinColumns = {@JoinColumn(
                    name = "anime_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "genero_id"
            )}
    )
    private List<Categoria> genero;
    @OneToMany(
            mappedBy = "anime",
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Episodios> episodios;

public AnimeSerie(){

}

    public AnimeSerie(DatosAnime datosAnime ) {
        this.idAnime = datosAnime.idAnime();
        this.titulo = datosAnime.titulo();
        this.tituloIngles = datosAnime.tituloIngles();
        this.tituloJapones = datosAnime.tituloJapones();
        this.tipo = datosAnime.tipo();
        this.fuente = datosAnime.fuente();
        this.status = datosAnime.status();
        this.duracion = datosAnime.duracion();
        this.rating = datosAnime.rating();
        this.puntaje = OptionalDouble.of(Double.valueOf(datosAnime.puntaje())).orElse(0.0);
        this.sinopsis = datosAnime.sinopsis();
        this.temporada = datosAnime.temporada();
        this.ano = datosAnime.ano();
        this.nEpisodios = datosAnime.nEpisodios();
    }

    public void DatosExtras(Videos urlVideo, Imagenes images, List<Fechas> fecha, List<Studios> studio, List<Licenciado> licenciado, List<Productores> productores) {
        this.urlVideo = urlVideo;
        this.images = images;
        this.fecha = fecha;
        this.studio = studio;
        this.licenciado = licenciado;
        this.productores = productores;
    }



    public Imagenes getImages() {
        return images;
    }

    public void setImages(Imagenes images) {
        this.images = images;
    }

    public Videos getUrlVideo() {
        return urlVideo ;
    }

    public void setUrlVideo(Videos urlVideo) {
        this.urlVideo = urlVideo;
    }

    public List<Fechas> getFecha() {
        return fecha;
    }

    public void setFecha(List<Fechas> fecha) {
        this.fecha = fecha;
    }

    public List<Productores> getProductores() {
        return productores;
    }

    public void setProductores(List<Productores> productores) {
        this.productores = productores;
    }

    public List<Licenciado> getLicenciado() {
        return licenciado;
    }

    public void setLicenciado(List<Licenciado> licenciado) {
        this.licenciado = licenciado;
    }

    public List<Studios> getStudio() {
        return studio;
    }

    public void setStudio(List<Studios> studio) {
        this.studio = studio;
    }

    public void Categoria(List<Categoria> genero) {
        this.genero = genero;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getIdAnime() {
        return idAnime;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getTituloIngles() {
        return tituloIngles;
    }

    public String getTituloJapones() {
        return tituloJapones;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFuente() {
        return fuente;
    }

    public Integer getnEpisodios() {
        return nEpisodios;
    }

    public String getStatus() {
        return status;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getRating() {
        return rating;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getTemporada() {
        return temporada;
    }

    public Integer getAno() {
        return ano;
    }

    public List<Categoria> getGenero() {
        return genero;
    }

    public void setGenero(List<Categoria> genero) {
        this.genero = genero;
    }

    public List<Episodios> getEpisodios() {
        return episodios;
    }


    public void setEpisodios(List<Episodios> episodios) {
        episodios.forEach((e) -> {
            e.setAnime(this);
        });
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "----------------------------------------------------------------------\n" +
                "AnimeSerie{" +
                "\nidAnime= " + idAnime +
                "\nimages= " + images +
                "\nurlVideo= " + urlVideo +
                "\ntitulo= " + titulo  +
                ", tituloIngles= " + tituloIngles  +
                ", tituloJapones= " + tituloJapones +
                "\ntipo= " + tipo  +
                "\nfuente= " + fuente  +
                "\nnEpisodios= " + nEpisodios +
                "\nstatus= " + status +
                "\nfecha= " + fecha +
                "\nduracion= " + duracion +
                "\nrating= " + rating +
                "\npuntaje= " + puntaje +
                "\ntemporada= " + temporada +
                "\naño= " + ano +
                "\nproductores= " + productores +
                "\nlicenciado= " + licenciado +
                "\nstudio= " + studio +
                "\ngenero= " + genero +
                "\nepisodios= " + episodios +
                "\nsinopsis= " + sinopsis +
                "}" +

                "\n--------------------------------------------------------------------";
    }
}
