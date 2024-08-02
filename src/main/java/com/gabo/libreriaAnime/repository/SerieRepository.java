package com.gabo.libreriaAnime.repository;

import com.gabo.libreriaAnime.model.Anime.AnimeSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<AnimeSerie, Long> {
    boolean existsByTitulo(String titulo);
}
