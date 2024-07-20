package com.gabo.libreriaAnime.dto.serie.infoSerie.images;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ImagesDatos(
        @JsonAlias("jpg") List<ImagesDetailsDatos> formato
) {
}
