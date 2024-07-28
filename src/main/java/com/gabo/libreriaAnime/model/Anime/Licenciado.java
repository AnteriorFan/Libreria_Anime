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
                "idProductora=" + idProductora +
                ", nombre='" + nombre;
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
