// src/main/java/cineconecta/cineconecta/models/tmdb/TmdbMovieDto.java
package cineconecta.cineconecta.models.tmdb;
//Representa una película tal como viene de la API de TMDb

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TmdbMovieDto {
    private Long id;
    private String title;
    @JsonProperty("release_date")
    private String releaseDate;
    private String overview;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("vote_average")
    private Double voteAverage;
    private List<GenreDto> genres;

    // ¡NUEVOS CAMPOS! para director, guionistas y actores
    private String director;
    private String writers; // Usaremos un String para guionistas por simplicidad
    private String actors;  // Usaremos un String para actores por simplicidad

    // Getters y Setters existentes
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }
    public String getPosterPath() { return posterPath; }
    public void setPosterPath(String posterPath) { this.posterPath = posterPath; }
    public Double getVoteAverage() { return voteAverage; }
    public void setVoteAverage(Double voteAverage) { this.voteAverage = voteAverage; }
    public List<GenreDto> getGenres() { return genres; }
    public void setGenres(List<GenreDto> genres) { this.genres = genres; }

    public String getReleaseYear() {
        if (releaseDate != null && releaseDate.length() >= 4) {
            return releaseDate.substring(0, 4);
        }
        return null;
    }

    // ¡NUEVOS GETTERS Y SETTERS para los campos añadidos!
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public String getWriters() { return writers; }
    public void setWriters(String writers) { this.writers = writers; }
    public String getActors() { return actors; }
    public void setActors(String actors) { this.actors = actors; }
}