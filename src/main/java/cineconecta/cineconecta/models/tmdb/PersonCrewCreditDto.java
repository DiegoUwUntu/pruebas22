package cineconecta.cineconecta.models.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

// Representa un crédito de equipo técnico (director, escritor, etc.) para una persona en una película
public class PersonCrewCreditDto {
    private Long id; // ID de la película
    private String job; // Ej: "Director", "Writer", "Producer"
    private String department; // Ej: "Directing", "Writing", "Production"
    private String title; // Título de la película
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("poster_path")
    private String posterPath;
    // Puedes añadir más campos de la película si los necesitas, como overview, vote_average, etc.

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
