package cineconecta.cineconecta.models.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TmdbPersonResult {
    private Long id;
    private String name;
    private Double popularity;
    @JsonProperty("profile_path")
    private String profilePath; // Ruta del poster de la persona
    @JsonProperty("known_for_department")
    private String knownForDepartment; // Ej: "Acting", "Directing"
    @JsonProperty("known_for")
    private List<TmdbMovieDto> knownFor; // Películas o programas conocidos (pueden ser TmdbMovieDto simplificados)

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        this.knownForDepartment = knownForDepartment;
    }

    public List<TmdbMovieDto> getKnownFor() {
        return knownFor;
    }

    public void setKnownFor(List<TmdbMovieDto> knownFor) {
        this.knownFor = knownFor;
    }
}
