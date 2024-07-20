package com.gabo.libreriaAnime.dto.serie.infoSerie;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gabo.libreriaAnime.dto.serie.infoSerie.date.FechaDatos;
import com.gabo.libreriaAnime.dto.serie.infoSerie.images.ImagesDatos;
import com.gabo.libreriaAnime.dto.serie.infoSerie.video.VideoDatos;

import java.util.List;

/**
 * DTO for Anime Data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAnime(
        @JsonAlias("mal_id") String idAnime,
        @JsonAlias("images") List<ImagesDatos> images,
        @JsonAlias("trailer") List<VideoDatos> urlVideo,
        @JsonAlias("title") String titulo,
        @JsonAlias("title_english") String tituloIngles,
        @JsonAlias("title_japanese") String tituloJapones,
        @JsonAlias("type") String tipo,
        @JsonAlias("source") String fuente,
        @JsonAlias("episodes") Integer nEpisodios,
        @JsonAlias("status") String status,
        @JsonAlias("aired") List<FechaDatos> fecha,
        @JsonAlias("duration") String duracion,
        @JsonAlias("rating") String rating,
        @JsonAlias("score") Double puntaje,
        @JsonAlias("synopsis") String sinopsis,
        @JsonAlias("season") String temporada,
        @JsonAlias("year") Integer ano,
        @JsonAlias("producers") List<ProductoresDatos> productores,
        @JsonAlias("licensors") List<LicenciadoDatos> licenciado,
        @JsonAlias("studios") List<StudiosDatos> studio,
        @JsonAlias("genres") List<GeneroDatos> genero
) {
}
