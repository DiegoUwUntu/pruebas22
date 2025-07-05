package cineconecta.cineconecta.models.tmdb;
//Representa una película tal como tu backend la representa a tu fronted

// Asegúrate de que esté en un paquete accesible, por ejemplo, cineconecta.cineconecta.models
public class MovieSearchResult {
    private Long tmdbId;
    private String title;
    private String year;
    private String imageUrl;
    private String description; // Añadido para los detalles
    private String genres; // Añadido para los detalles
    private String director; // Añadido para los detalles
    private String writers; // Añadido para los detalles
    private String actors; // Añadido para los detalles
    private Integer generalRating; // Añadido para los detalles

    // Constructor para la búsqueda
    public MovieSearchResult(Long tmdbId, String title, String year, String imageUrl) {
        this.tmdbId = tmdbId;
        this.title = title;
        this.year = year;
        this.imageUrl = imageUrl;
    }

    // Constructor vacío (necesario para algunos frameworks como Jackson)
    public MovieSearchResult() {}

    // Getters y Setters para todos los campos (generados automáticamente en la mayoría de IDEs)
    public Long getTmdbId() { return tmdbId; }
    public void setTmdbId(Long tmdbId) { this.tmdbId = tmdbId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getGenres() { return genres; }
    public void setGenres(String genres) { this.genres = genres; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public String getWriters() { return writers; }
    public void setWriters(String writers) { this.writers = writers; }
    public String getActors() { return actors; }
    public void setActors(String actors) { this.actors = actors; }
    public Integer getGeneralRating() { return generalRating; }
    public void setGeneralRating(Integer generalRating) { this.generalRating = generalRating; }
}