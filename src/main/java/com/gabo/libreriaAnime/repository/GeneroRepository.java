package com.gabo.libreriaAnime.repository;

import com.gabo.libreriaAnime.dto.serie.infoSerie.Genero;
import com.gabo.libreriaAnime.model.Anime.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository  extends JpaRepository<Categoria, Long> {

}
