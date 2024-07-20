package com.gabo.libreriaAnime.dto.serie.infoSerie;

import com.fasterxml.jackson.annotation.JsonAlias;

public record ProductoresDatos(
        @JsonAlias("mal_id") Integer idProductora,
        @JsonAlias("name") String nombre
) {
}
