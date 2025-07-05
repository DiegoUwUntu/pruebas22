package cineconecta.cineconecta.controllers.Fimls;
// src/main/java/cineconecta/cineconecta/controllers/Films/MovieController.java

import cineconecta.cineconecta.models.tmdb.TmdbMovieDto;
import cineconecta.cineconecta.models.tmdb.TmdbMovieSearchResponse;
import cineconecta.cineconecta.models.tmdb.MovieSearchResult;
import cineconecta.cineconecta.models.tmdb.TmdbPersonSearchResponse;
import cineconecta.cineconecta.service.Films.TmdbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList; // Necesario si usas un dummy list
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/cine/api/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    // Declara una instancia de tu TmdbService
    private final TmdbService tmdbService;

    // Mapa de nombres de género a IDs de TMDb (ejemplo, debes completarlo con los que uses)
    // TMDb tiene un endpoint /genre/movie/list para obtener esta lista
    private static final Map<String, String> GENRE_MAP = new HashMap<>();
    static {
        GENRE_MAP.put("accion", "28"); // Ejemplo: Acción
        GENRE_MAP.put("comedia", "35"); // Ejemplo: Comedia
        GENRE_MAP.put("drama", "18");   // Ejemplo: Drama
        GENRE_MAP.put("ciencia ficcion", "878"); // Ejemplo: Ciencia Ficción
        GENRE_MAP.put("aventura", "12"); // Ejemplo: Aventura
        GENRE_MAP.put("fantasia", "14"); // Ejemplo: Fantasía
        GENRE_MAP.put("familia", "10751"); // Ejemplo: Familia
        GENRE_MAP.put("romance", "10749"); // Ejemplo: Romance
        GENRE_MAP.put("terror", "27"); // Ejemplo: Terror
        GENRE_MAP.put("crimen", "80"); // Ejemplo: Crimen
        GENRE_MAP.put("animacion", "16"); // Ejemplo: Animación
        GENRE_MAP.put("documental", "99"); // Ejemplo: Documental
        GENRE_MAP.put("historia", "36"); // Ejemplo: Historia
        GENRE_MAP.put("musica", "10402"); // Ejemplo: Música
        GENRE_MAP.put("misterio", "9648"); // Ejemplo: Misterio
        GENRE_MAP.put("western", "37"); // Ejemplo: Western
        GENRE_MAP.put("thriller", "53"); // Ejemplo: Thriller
        GENRE_MAP.put("guerra", "10752"); // Ejemplo: Guerra
        GENRE_MAP.put("tv movie", "10770"); // Ejemplo: Película de TV
    }

    // Inyección de dependencias a través del constructor
    @Autowired
    public MovieController(TmdbService tmdbService) { // <-- Spring inyectará TmdbService aquí
        this.tmdbService = tmdbService;
    }

    // Endpoint para buscar películas por título, género, año, director
    @GetMapping("/search")
    public ResponseEntity<List<MovieSearchResult>> searchMovies(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String director) {

        List<MovieSearchResult> results = new ArrayList<>(); // Inicializa una lista vacía
        Optional<TmdbMovieSearchResponse> tmdbResponse = Optional.empty();

        // Lógica de búsqueda condicional basada en los parámetros proporcionados
        // Aquí es donde integrarías tu lógica de llamada a TMDb o a tu propia base de datos.
        // TMDb tiene métodos separados para buscar por título, descubrir por año/género, etc.
        // Necesitarás adaptar las llamadas a tmdbApiService.

        if (query != null && !query.trim().isEmpty()) {
            // Llama al metodo searchMovies de tu TmdbService para buscar por query
            tmdbResponse = tmdbService.searchMovies(query);
        } else if (genre != null && !genre.trim().isEmpty()) {
            String genreId = GENRE_MAP.get(genre.toLowerCase()); // Obtener el ID del género
            if (genreId != null) {
                // Llama al metodo discoverMovies de tu TmdbService para buscar por género y/o año
                tmdbResponse = tmdbService.discoverMovies(genreId, year); // Implementar discoverMovies en TmdbService
            } else {
                return ResponseEntity.badRequest().body(Collections.emptyList()); // Género no válido
            }
        } else if (year != null) {
            // Llama al metodo discoverMovies de tu TmdbService para buscar por año (sin género específico)
            tmdbResponse = tmdbService.discoverMovies(null, year); // Implementar discoverMovies en TmdbService
        } else if (director != null && !director.trim().isEmpty()) {
            // Primero busca al director por nombre
            Optional<TmdbPersonSearchResponse> personSearchResponse = tmdbService.searchPerson(director); // Implementar searchPerson en TmdbService

            if (personSearchResponse.isPresent() && !personSearchResponse.get().getResults().isEmpty()) {
                // Asume el primer resultado como el director principal (puedes refinar esto)
                Long directorId = personSearchResponse.get().getResults().get(0).getId();
                // Luego busca las películas asociadas a esa persona (director)
                tmdbResponse = tmdbService.getMoviesByPerson(directorId); // Implementar getMoviesByPerson en TmdbService
            } else {
                return ResponseEntity.status(404).body(Collections.emptyList()); // Director no encontrado
            }
        } else {
            // Si no se proporciona ningún parámetro de búsqueda, puedes devolver un badRequest
            // o un conjunto de películas populares/próximas si tu TmdbService lo permite.
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        if (tmdbResponse.isPresent()) {
            results = tmdbResponse.get().getResults().stream()
                    .map(tmdbMovie -> new MovieSearchResult(
                            tmdbMovie.getId(),
                            tmdbMovie.getTitle(),
                            tmdbMovie.getReleaseDate() != null && tmdbMovie.getReleaseDate().length() >= 4 ? tmdbMovie.getReleaseDate().substring(0, 4) : "N/A",
                            tmdbService.getFullPosterUrl(tmdbMovie.getPosterPath()).orElse("/default-poster.png")
                    ))
                    .collect(Collectors.toList());
        }

        if (results.isEmpty()) {
            return ResponseEntity.status(404).body(Collections.emptyList()); // Devuelve 404 con lista vacía si no hay resultados
        }
        return ResponseEntity.ok(results);
    }

    // Endpoint para obtener detalles de una película
    @GetMapping("/{tmdbId}")
    public ResponseEntity<MovieSearchResult> getMovieById(@PathVariable Long tmdbId) {
        Optional<TmdbMovieDto> tmdbMovieDtoOptional = tmdbService.getMovieDetails(tmdbId);

        if (tmdbMovieDtoOptional.isPresent()) {
            TmdbMovieDto tmdbMovieDto = tmdbMovieDtoOptional.get();
            MovieSearchResult movieDetails = new MovieSearchResult(
                    tmdbMovieDto.getId(),
                    tmdbMovieDto.getTitle(),
                    tmdbMovieDto.getReleaseDate() != null && tmdbMovieDto.getReleaseDate().length() >=4 ? tmdbMovieDto.getReleaseDate().substring(0,4): "N/A",
                    tmdbService.getFullPosterUrl(tmdbMovieDto.getPosterPath()).orElse("/default-poster.png")
            );
            // Mapea los campos adicionales que has añadido en el DTO de detalle
            movieDetails.setDescription(tmdbMovieDto.getOverview());
            movieDetails.setGenres(tmdbMovieDto.getGenres() != null ? tmdbMovieDto.getGenres().stream().map(g -> g.getName()).collect(Collectors.joining(", ")) : "N/A");
            movieDetails.setDirector(tmdbMovieDto.getDirector());
            movieDetails.setWriters(tmdbMovieDto.getWriters());
            movieDetails.setActors(tmdbMovieDto.getActors());
            // Calcula una calificación general ficticia o real si la tienes en TmdbMovieDto
            // Aquí getVote_average es de TmdbMovieDto. Asumiendo que quieres el valor entero.
            movieDetails.setGeneralRating(tmdbMovieDto.getVoteAverage() != null ? tmdbMovieDto.getVoteAverage().intValue() : 0);

            return ResponseEntity.ok(movieDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}