package com.gabo.libreriaAnime.dto.serie.infoSerie.date;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record FechaNoseDatos(
        @JsonAlias("from") List<FechaToDatos> from,
        @JsonAlias("to") List<FechaToDatos> to
) {
}

