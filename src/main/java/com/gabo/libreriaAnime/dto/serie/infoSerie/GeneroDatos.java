package com.gabo.libreriaAnime.dto.serie.infoSerie;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeneroDatos(
        @JsonAlias("mal_id") Integer id_genero,
        @JsonAlias("name") String generoAnime
) { }
