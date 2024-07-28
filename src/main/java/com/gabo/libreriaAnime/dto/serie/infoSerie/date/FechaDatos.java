package com.gabo.libreriaAnime.dto.serie.infoSerie.date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record FechaDatos(
        //@JsonAlias("prop") List<FechaNoseDatos> nose,
        @JsonAlias("string") String string

) { }
