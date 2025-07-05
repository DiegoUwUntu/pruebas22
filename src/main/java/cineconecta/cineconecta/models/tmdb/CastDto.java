// src/main/java/cineconecta/cineconecta/models/tmdb/CastDto.java
package cineconecta.cineconecta.models.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CastDto {
    private Integer id;
    private String name;
    @JsonProperty("character")
    private String characterName;
    // Otros campos como profile_path, order, etc. si los necesitas

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCharacterName() { return characterName; }
    public void setCharacterName(String characterName) { this.characterName = characterName; }
}