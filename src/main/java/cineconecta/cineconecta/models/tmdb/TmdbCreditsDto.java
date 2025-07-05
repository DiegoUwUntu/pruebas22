// src/main/java/cineconecta/cineconecta/models/tmdb/TmdbCreditsDto.java
package cineconecta.cineconecta.models.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TmdbCreditsDto {
    private Integer id;
    private List<CastDto> cast;
    private List<CrewDto> crew;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public List<CastDto> getCast() { return cast; }
    public void setCast(List<CastDto> cast) { this.cast = cast; }
    public List<CrewDto> getCrew() { return crew; }
    public void setCrew(List<CrewDto> crew) { this.crew = crew; }
}