package com.gabo.libreriaAnime.dto.serie.infoSerie;

import java.text.Normalizer;
import java.util.Locale;

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
    AwardWinning("Award Winning", "Award Winning"),
    CYBERPUNK("Cyberpunk", "Cyberpunk");

    private final String categoriaAnime;
    private final String categoriaEspanol;

    private Genero(String categoriaAnime, String categoriaEspanol) {
        this.categoriaAnime = categoriaAnime;
        this.categoriaEspanol = categoriaEspanol;
    }

    //Busca y normaliza el resultado, ejemplo: Acción a accion pero en ingles
    public static Genero fromString(String text) {
        String normalizedText = normalize(text);
        for (Genero categoria : Genero.values()) {
            if (normalize(categoria.categoriaEspanol).equalsIgnoreCase(normalizedText)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    //Busca y normaliza el resultado, ejemplo: Acción a accion
    public static Genero fromEspanol(String text) {
        String normalizedText = normalize(text);
        for (Genero categoria : Genero.values()) {
            if (normalize(categoria.categoriaAnime).equalsIgnoreCase(normalizedText)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    //Normaliza la busqueda por medio de fases, ejemplo: Acción a accion
    private static String normalize(String text) {
        //En esta forma, los caracteres acentuados se descomponen en su carácter base y su acento.
        //      Por ejemplo, "á" se descompondría en "a" y el acento agudo.
        return Normalizer.normalize(text, Normalizer.Form.NFD)

                // Este método utiliza una expresión regular para eliminar todos los caracteres diacríticos
                //      (los acentos y otros signos que se pueden añadir a las letras).
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")

                //Convierte el texto resultante a minúsculas utilizando Locale.ROOT
                //          para asegurar que la conversión se realice de manera consistente
                //              sin tener en cuenta la localización específica del sistema
                .toLowerCase(Locale.ROOT);
    }
}
