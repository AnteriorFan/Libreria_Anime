package com.gabo.libreriaAnime.dto.serie.infoSerie.date;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record FechaDatos(
        @JsonAlias("prop") List<FechaNoseDatos> nose
) {
}
