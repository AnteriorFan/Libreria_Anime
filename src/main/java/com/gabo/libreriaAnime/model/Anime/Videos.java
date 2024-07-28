package com.gabo.libreriaAnime.model.Anime;


import com.gabo.libreriaAnime.dto.serie.infoSerie.video.VideoDatos;
import jakarta.persistence.*;

@Entity
@Table(name="videos")
public class Videos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String idyoutube;
    @OneToOne
    @JoinColumn(name = "anime_id")
    private AnimeSerie anime;
    public Videos(){}
    public Videos(VideoDatos videoDatos){
      this.url = videoDatos.url();
      this.idyoutube = videoDatos.idyoutube();
    }


    public String getIdyoutube() {
        return idyoutube;
    }

    public void setIdyoutube(String idyoutube) {
        this.idyoutube = idyoutube;
    }

    public String getUrl() {
        return url != null ? url : "N/A";
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
