package com.gabo.libreriaAnime.model.Anime;

import com.gabo.libreriaAnime.dto.serie.infoSerie.Genero;

public class Categoria {
    private Long id;
    private Genero categoria;

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
