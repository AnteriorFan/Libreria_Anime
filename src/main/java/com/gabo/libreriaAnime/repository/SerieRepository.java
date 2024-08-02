package com.gabo.libreriaAnime.repository;

import com.gabo.libreriaAnime.dto.serie.infoSerie.Genero;
import com.gabo.libreriaAnime.model.Anime.AnimeSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerieRepository extends JpaRepository<AnimeSerie, Long> {
    boolean existsByTitulo(String titulo);

    @Query("SELECT a FROM AnimeSerie a JOIN a.genero g WHERE g.categoria = :categoria")
    List<AnimeSerie> findByCategoriaGenero(Genero categoria);
}
