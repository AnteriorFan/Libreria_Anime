package com.gabo.libreriaAnime.dto.serie.infoSerie.images;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public record ImagesDatos(
        @JsonProperty("webp")
        ImagesDetailsDatos formato
) { }
