package cineconecta.cineconecta.models.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// Esta clase representa la respuesta del endpoint /person/{person_id}/movie_credits
// Es decir, las películas en las que una persona ha participado.
public class PersonMovieCreditsResponse {
    private Long id; // ID de la persona
    @JsonProperty("cast")
    private List<PersonCastCreditDto> movieCastCredits; // Lista de créditos de películas como actor
    @JsonProperty("crew")
    private List<PersonCrewCreditDto> movieCrewCredits; // Lista de créditos de películas como miembro del equipo

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PersonCastCreditDto> getMovieCastCredits() {
        return movieCastCredits;
    }

    public void setMovieCastCredits(List<PersonCastCreditDto> movieCastCredits) {
        this.movieCastCredits = movieCastCredits;
    }

    public List<PersonCrewCreditDto> getMovieCrewCredits() {
        return movieCrewCredits;
    }

    public void setMovieCrewCredits(List<PersonCrewCreditDto> movieCrewCredits) {
        this.movieCrewCredits = movieCrewCredits;
    }
}
