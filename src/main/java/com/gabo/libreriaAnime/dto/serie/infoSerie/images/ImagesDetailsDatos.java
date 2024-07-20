package com.gabo.libreriaAnime.dto.serie.infoSerie.images;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ImagesDetailsDatos(
        @JsonAlias("image_url") String imageUrl,
        @JsonAlias("small_image_url") String smallImageUrl,
        @JsonAlias("large_image_url") String largeImageUrl
) {
}
