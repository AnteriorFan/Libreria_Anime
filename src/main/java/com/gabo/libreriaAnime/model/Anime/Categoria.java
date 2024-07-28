package com.gabo.libreriaAnime.model.Anime;

import com.gabo.libreriaAnime.dto.serie.infoSerie.Genero;
import jakarta.persistence.*;


@Entity
@Table(
        name = "generos"
)
public class Categoria {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Enumerated(EnumType.STRING)
    private Genero categoria;

    public Categoria(){ }
    public Categoria(Genero categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Genero getCategoria() {
        return categoria;
    }

    public void setCategoria(Genero categoria) {
        this.categoria = categoria;
    }

    public String toString() {
        return this.categoria.name();
    }
}
