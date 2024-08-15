package com.gabo.libreriaAnime.dto.serie.episodes;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodios(
        @JsonAlias("data") List<DatosEpisodesResult> dataEpisodes
) {
}
