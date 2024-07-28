package com.gabo.libreriaAnime.dto.serie.infoSerie;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gabo.libreriaAnime.dto.serie.infoSerie.date.FechaDatos;
import com.gabo.libreriaAnime.dto.serie.infoSerie.images.ImagesDatos;
import com.gabo.libreriaAnime.dto.serie.infoSerie.video.VideoDatos;

import java.util.List;

/**
 * DTO for Anime Data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAnime(
        @JsonAlias("mal_id") Integer idAnime,
        @JsonAlias("images") ImagesDatos images,
        @JsonAlias("trailer") VideoDatos urlVideo,
        @JsonAlias("title") String titulo,
        @JsonAlias("title_english") String tituloIngles,
        @JsonAlias("title_japanese") String tituloJapones,
        @JsonAlias("type") String tipo,
        @JsonAlias("source") String fuente,
        @JsonAlias("episodes") Integer nEpisodios,
        @JsonAlias("status") String status,
        @JsonAlias("aired") FechaDatos fecha,
        @JsonAlias("duration") String duracion,
        @JsonAlias("rating") String rating,
        @JsonAlias("score") Double puntaje,
        @JsonAlias("synopsis") String sinopsis,
        @JsonAlias("season") String temporada,
        @JsonAlias("year") Integer ano,
        @JsonAlias("producers") List<ProductoresDatos> productores,
        @JsonAlias("licensors") List<LicenciadoDatos> licenciado,
        @JsonAlias("studios") List<StudiosDatos> studio,
        @JsonAlias("genres") List<GeneroDatos> genero
) {
    @Override
    public String toString() {
        return "DatosAnime{" +
                "\nidAnime=" + idAnime +
                ",\nImages=" + images +
                ",\nURL_Video=" + urlVideo +
                ",\nTitulo='" + titulo + '\'' +
                ", tituloIngles='" + tituloIngles + '\'' +
                ", tituloJapones='" + tituloJapones + '\'' +
                ",\nTipo='" + tipo + '\'' +
                ",\nFuente='" + fuente + '\'' +
                ",\nNEpisodios=" + nEpisodios +
                ",\nStatus='" + status + '\'' +
                ",\nFecha=" + fecha +
                ",\nDuracion='" + duracion + '\'' +
                ",\nRating='" + rating + '\'' +
                ",\nPuntaje=" + puntaje +
                ",\nTemporada='" + temporada + '\'' +
                ",\nAño=" + ano +
                ",\nProductores=" + productores +
                ",\nLicenciado=" + licenciado +
                ",\nStudio=" + studio +
                ",\nGenero=" + genero +
                ",\nSinopsis='" + sinopsis + '\'' +
                '}';
    }
}
