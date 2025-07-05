package cineconecta.cineconecta.service.Films;
// src/main/java/cineconecta/cineconecta/service/Films/CppMovieApiClient.java

import cineconecta.cineconecta.models.tmdb.MovieSearchResult;
import cineconecta.cineconecta.models.tmdb.TmdbMovieDto; // Si decides que C++ devuelva un TmdbMovieDto
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.databind.ObjectMapper; // Para construir JSON en Java
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CppMovieApiClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper; // Para crear objetos JSON

    @Value("http://localhost:5000") // URL de tu API de C++
    private String cppApiBaseUrl;

    public CppMovieApiClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Optional<List<MovieSearchResult>> searchMoviesInCpp(String query, String genreId, Integer year) {
        String url = cppApiBaseUrl + "/api/movies/search-proxy";

        ObjectNode requestBody = objectMapper.createObjectNode();
        if (query!= null &&!query.isEmpty()) {
            requestBody.put("query", query);
        }
        if (genreId!= null &&!genreId.isEmpty()) {
            requestBody.put("genreId", genreId);
        }
        if (year!= null) {
            requestBody.put("year", year);
        }

        try {
            // C++ devuelve una lista de MovieSearchResult directamente
            MovieSearchResult results = restTemplate.postForObject(url, requestBody, MovieSearchResult.class);
            return Optional.ofNullable(Arrays.asList(results));
        } catch (Exception e) {
            System.err.println("Error al llamar a la API C++ para búsqueda de películas: " + e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<MovieSearchResult> getMovieDetailsInCpp(Long tmdbId) {
        String url = UriComponentsBuilder.fromUriString(cppApiBaseUrl + "/api/movies/{tmdbId}/details-proxy")
               .buildAndExpand(tmdbId).toUriString();
        try {
            // C++ devuelve un MovieSearchResult directamente
            return Optional.ofNullable(restTemplate.getForObject(url, MovieSearchResult.class));
        } catch (Exception e) {
            System.err.println("Error al llamar a la API C++ para detalles de película: " + e.getMessage());
            return Optional.empty();
        }
    }
}
