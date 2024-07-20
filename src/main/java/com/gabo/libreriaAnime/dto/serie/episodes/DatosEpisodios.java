package com.gabo.libreriaAnime.dto.serie.episodes;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DatosEpisodios(
        @JsonAlias("data") List<DatosEpisodesResult> dataEpisodes
) {
}
