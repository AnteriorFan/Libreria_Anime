package com.gabo.libreriaAnime.model.Anime;

import com.gabo.libreriaAnime.dto.serie.infoSerie.ProductoresDatos;
import jakarta.persistence.*;

@Entity
@Table(name="productores")
public class Productores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer idProductora;
     private String nombre;
    @ManyToOne
    @JoinColumn(name = "anime_id")
    private AnimeSerie anime;

     public Productores(){}
     public Productores (ProductoresDatos productoresDatos){
         this.idProductora = productoresDatos.idProductora();
         this.nombre = productoresDatos.nombre();
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
