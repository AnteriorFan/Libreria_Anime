package com.gabo.libreriaAnime.model.Anime;

import com.gabo.libreriaAnime.dto.serie.infoSerie.StudiosDatos;
import jakarta.persistence.*;

@Entity
@Table(name="studios")
public class Studios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer idProductora;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private AnimeSerie anime;
    public Studios(){}
    public Studios(StudiosDatos studiosDatos){
        this.idProductora = studiosDatos.idProductora();
        this.nombre = studiosDatos.nombre();
    }

    @Override
    public String toString() {
        return
                "nombre= " + nombre ;
    }

    public Integer getIdProductora() {
        return idProductora != null ? idProductora: 100;
    }

    public void setIdProductora(Integer idProductora) {
        this.idProductora = idProductora;
    }

    public String getNombre() {
        return nombre != null ? nombre : "N/A";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnimeSerie getAnime() {
        return anime;
    }

    public void setAnime(AnimeSerie anime) {
        this.anime = anime;
    }
}
