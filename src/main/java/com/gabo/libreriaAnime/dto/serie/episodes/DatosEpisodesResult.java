package com.gabo.libreriaAnime.dto.serie.episodes;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodesResult(
        @JsonAlias("mal_id") Integer idEpisode,
        @JsonAlias("title") String titulo,
        @JsonAlias("title_japanese") String tituloJapones,
        @JsonAlias("score") Double calificacionEpisode) {
}
