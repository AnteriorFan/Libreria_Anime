package com.gabo.libreriaAnime.model.Anime;

import com.gabo.libreriaAnime.dto.serie.infoSerie.*;
import com.gabo.libreriaAnime.dto.serie.infoSerie.date.FechaDatos;
import com.gabo.libreriaAnime.dto.serie.infoSerie.images.ImagesDatos;
import com.gabo.libreriaAnime.dto.serie.infoSerie.video.VideoDatos;

import java.util.List;
import java.util.OptionalDouble;

public class AnimeSerie {

    private final String idAnime;

    private final List<ImagesDatos> images;

    private final List<VideoDatos> urlVideo;

    private final String titulo;

    private final String tituloIngles;

    private final String tituloJapones;

    private final String tipo;

    private final String fuente;

    private final Integer nEpisodios;

    private final String status;

    private final List<FechaDatos> fecha;

    private final String duracion;

    private final String rating;

    private final Double puntaje;

    private final String sinopsis;

    private final String temporada;

    private final Integer ano;

    private final List<ProductoresDatos> productores;

    private final List<LicenciadoDatos> licenciado;

    private final List<StudiosDatos> studio;

    private List<Categoria> genero;
    private List<Episodios> episodios;

    public AnimeSerie(DatosAnime datosAnime) {
        this.idAnime = datosAnime.idAnime();
        this.images = datosAnime.images();
        this.urlVideo = datosAnime.urlVideo();
        this.titulo = datosAnime.titulo();
        this.tituloIngles = datosAnime.tituloIngles();
        this.tituloJapones = datosAnime.tituloJapones();
        this.tipo = datosAnime.tipo();
        this.fuente = datosAnime.fuente();
        this.status = datosAnime.status();
        this.fecha = datosAnime.fecha();
        this.duracion = datosAnime.duracion();
        this.rating = datosAnime.rating();
        this.puntaje = OptionalDouble.of(Double.valueOf(datosAnime.puntaje())).orElse(0.0);
        this.sinopsis = datosAnime.sinopsis();
        this.temporada = datosAnime.temporada();
        this.ano = datosAnime.ano();
        this.productores = datosAnime.productores();
        this.licenciado = datosAnime.licenciado();
        this.studio = datosAnime.studio();
        this.nEpisodios = datosAnime.nEpisodios();
    }

    public void Categoria(List<Categoria> genero) {
        this.genero = genero;
    }


    public String getIdAnime() {
        return idAnime;
    }

    public List<ImagesDatos> getImages() {
        return images;
    }

    public List<VideoDatos> getUrlVideo() {
        return urlVideo;
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

    public List<FechaDatos> getFecha() {
        return fecha;
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

    public List<ProductoresDatos> getProductores() {
        return productores;
    }

    public List<LicenciadoDatos> getLicenciado() {
        return licenciado;
    }

    public List<StudiosDatos> getStudio() {
        return studio;
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
}
