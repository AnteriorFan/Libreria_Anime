package com.gabo.libreriaAnime.dto.serie.infoSerie.date;

import com.fasterxml.jackson.annotation.JsonAlias;

public record FechaToDatos(
        @JsonAlias("day") Integer dia,
        @JsonAlias("month") Integer mes,
        @JsonAlias("year") Integer anoi
) {
}
