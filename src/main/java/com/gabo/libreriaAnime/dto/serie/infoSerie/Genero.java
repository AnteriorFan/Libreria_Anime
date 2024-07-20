package com.gabo.libreriaAnime.dto.serie.infoSerie;

public enum Genero {
    COMEDIA("Comedy", "Comedia"),
    AVENTURA("Adventure", "Aventura"),
    ACCION("Action", "Acción"),
    CRIMEN("Crime", "Crimen"),
    DRAMA("Drama", "Drama"),
    COMBATSPORTS("Combat Sports", "Combat Sports"),
    FANTASIA("Fantasy", "Fantasía"),
    HORROR("Horror", "Horror"),
    MISTERIO("Mystery", "Misterio"),
    ROMANCE("Romance", "Romance"),
    SUPERNATURAL("Supernatural", "Supernatural"),
    ADULTCAST("Adult Cast", "Adult Cast"),
    ISEKAI("Isekai", "Isekai"),
    MECHA("Mecha", "Mecha"),
    ARTESMARCIALES("Martial Arts", "Artes Marciales"),
    RENCARNACION("Reincarnation", "Reencarnación"),
    SUPERPOWER("Super Power", "Super Power"),
    SHOUNEN("Shounen", "Shounen"),
    SEINEN("Seinen", "Seinen"),
    SHOUJO("Shoujo", "Shoujo"),
    JOSEI("Josei", "Josei"),
    VIDEOGAME("Video Game", "Video Game"),
    PARODIA("Parody", "Parodia"),
    SLICEOFLIFE("Slice of Life", "Slice of Life"),
    SCIFI("Sci-Fi", "Sci-Fi"),
    PSYCHOLOGICAL("Psychological", "Psicológico"),
    ECCHI("Ecchi", "Ecchi"),
    HAREM("Harem", "Harem"),
    REVERSEHAREM("Reverse Harem", "Reverse Harem"),
    MUSIC("Music", "Música"),
    SPORTS("Sports", "Deportes"),
    SCHOOL("School", "Escuela"),
    HISTORICAL("Historical", "Historical"),
    MILITARY("Military", "Military"),
    SPACE("Space", "Space"),
    THRILLER("Thriller", "Thriller"),
    DEMONS("Demons", "Demonios"),
    MAGIC("Magic", "Magia"),
    VAMPIRE("Vampire", "Vampiros"),
    KIDS("Kids", "Niños"),
    SAMURAI("Samurai", "Samurái"),
    YAOI("Yaoi", "Yaoi"),
    YURI("Yuri", "Yuri"),
    DEMENTIA("Dementia", "Dementia"),
    POLICE("Police", "Police"),
    GORE("Gore", "Gore"),
    TRAGEDY("Tragedy", "Tragedias"),
    GAME("Game", "Juegos"),
    MagicalSexShift("Magical Sex Shift", "Magical Sex Shift"),
    CYBERPUNK("Cyberpunk", "Cyberpunk");

    private final String categoriaAnime;
    private final String categoriaEspanol;

    private Genero(String categoriaAnime, String categoriaEspanol) {
        this.categoriaAnime = categoriaAnime;
        this.categoriaEspanol = categoriaEspanol;
    }

    public static Genero fromString(String text) {
        for (Genero categoria : Genero.values()) {
            if (categoria.categoriaAnime.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public static Genero fromEspanol(String text) {
        for (Genero categoria : Genero.values()) {
            if (categoria.categoriaEspanol.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}
