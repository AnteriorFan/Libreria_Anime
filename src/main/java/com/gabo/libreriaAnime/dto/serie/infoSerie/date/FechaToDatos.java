package com.gabo.libreriaAnime.dto.serie.infoSerie.date;

import com.fasterxml.jackson.annotation.JsonAlias;

public record FechaToDatos(
        @JsonAlias("day") Integer day,
        @JsonAlias("month") Integer month,
        @JsonAlias("year") Integer year
) {
}
