package com.gabo.libreriaAnime.model.Anime;

import com.gabo.libreriaAnime.dto.serie.infoSerie.images.ImagesDetailsDatos;
import jakarta.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
   private String smallImageUrl;
   private String largeImageUrl;
    @OneToOne
    @JoinColumn(name = "anime_id")
    private AnimeSerie anime;

   public Imagenes(){}
   public Imagenes(ImagesDetailsDatos imagesDetailsDatos){
       this.imageUrl = imagesDetailsDatos.imageUrl();
       this.smallImageUrl = imagesDetailsDatos.smallImageUrl();
       this.largeImageUrl = imagesDetailsDatos.largeImageUrl();
   }

    public String getImageUrl() {
        return imageUrl != null ? imageUrl : "N/A";
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl != null ? smallImageUrl : "N/A";
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public String getLargeImageUrl() {
        return largeImageUrl != null ? largeImageUrl : "N/A";
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

}
