package com.gabo.libreriaAnime.dto.serie.infoSerie.video;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VideoDatos(
        @JsonAlias("youtube_id") String idyoutube,
        @JsonAlias("url") String url
) { }
