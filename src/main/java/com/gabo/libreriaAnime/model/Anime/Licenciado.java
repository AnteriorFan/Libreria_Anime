package com.gabo.libreriaAnime.model.Anime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.gabo.libreriaAnime.dto.serie.infoSerie.LicenciadoDatos;
import jakarta.persistence.*;

@Entity
@Table(name="licenciado")
public class Licenciado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer idProductora;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "anime_id")
    private AnimeSerie anime;

    public Licenciado(){}
    public Licenciado(LicenciadoDatos licenciadoDatos){
        this.idProductora = licenciadoDatos.idProductora();
        this.nombre = licenciadoDatos.nombre();
    }

    @Override
    public String toString() {
        return

                "nombre= " + nombre;
    }

    public Integer getIdProductora() {
        return idProductora != null ? idProductora : 100;
    }

    public void setIdProductora(Integer idProductora) {
        this.idProductora = idProductora;
    }

    public String getNombre() {
        return nombre  != null ? nombre : "N/A";
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
