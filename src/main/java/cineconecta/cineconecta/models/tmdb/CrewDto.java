// src/main/java/cineconecta/cineconecta/models/tmdb/CrewDto.java
package cineconecta.cineconecta.models.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrewDto {
    private Integer id;
    private String name;
    private String job;
    private String department;
    // Otros campos como profile_path, credit_id, etc.

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}