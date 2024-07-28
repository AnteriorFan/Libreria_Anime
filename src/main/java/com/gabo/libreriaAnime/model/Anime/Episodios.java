package com.gabo.libreriaAnime.model.Anime;

import com.gabo.libreriaAnime.dto.serie.episodes.DatosEpisodesResult;
import jakarta.persistence.*;

@Entity
@Table(
        name = "episodios"
)
public class Episodios {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long Id;
    private Integer idEpisode;
    private String titulo;
    private String tituloJapones;
    private Double calificacionEpisode;
    @ManyToOne
    @JoinColumn(
            name = "anime_id"
    )
    private AnimeSerie anime;

    public Episodios() {
    }

    public Episodios(DatosEpisodesResult d, AnimeSerie a) {
        this.idEpisode = d.idEpisode();
        this.titulo = d.titulo();
        this.tituloJapones = d.tituloJapones();

        try {
            this.calificacionEpisode = d.calificacionEpisode();
        } catch (NumberFormatException var4) {
            this.calificacionEpisode = 0.0;
        }

        this.anime = a;
    }

    @Override
    public String toString() {
        return "\nidEpisode= " + idEpisode +
                ".\ntitulo= '" + titulo + '\'' +
                ".\ntituloJapones= '" + tituloJapones + '\'' +
                ".\ncalificacionEpisode= " + calificacionEpisode +
                ".\nanime= " + (this.anime != null ? this.anime.getTitulo() : "null");
    }


    public Integer getIdEpisode() {
        return idEpisode;
    }

    public void setIdEpisode(Integer idEpisode) {
        this.idEpisode = idEpisode;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloJapones() {
        return tituloJapones;
    }

    public void setTituloJapones(String tituloJapones) {
        this.tituloJapones = tituloJapones;
    }

    public Double getCalificacionEpisode() {
        return calificacionEpisode;
    }

    public void setCalificacionEpisode(Double calificacionEpisode) {
        this.calificacionEpisode = calificacionEpisode;
    }

    public AnimeSerie getAnime() {
        return anime;
    }

    public void setAnime(AnimeSerie anime) {
        this.anime = anime;
    }
}
