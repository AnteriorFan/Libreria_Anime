package com.gabo.libreriaAnime.dto.serie.infoSerie;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductoresDatos(
        @JsonAlias("mal_id") Integer idProductora,
        @JsonAlias("name") String nombre
) { }
