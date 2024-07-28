package com.gabo.libreriaAnime.model.Anime;

import com.gabo.libreriaAnime.dto.serie.infoSerie.date.FechaDatos;
import jakarta.persistence.*;

@Entity
@Table(name = "fecha")
public class Fechas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String string;
    @ManyToOne
    @JoinColumn(name = "anime_id")
    private AnimeSerie anime;
    public Fechas(FechaDatos fechaDatos){
        this.string = fechaDatos.string();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
