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

    public Integer getIdProductora() {
        return idProductora;
    }

    public void setIdProductora(Integer idProductora) {
        this.idProductora = idProductora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
