package cineconecta.cineconecta.controllers.Fimls;

import cineconecta.cineconecta.service.Films.LogroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/cine/logros")
public class LogroController {

    private final LogroService logroService;
    private final RestTemplate restTemplate = new RestTemplate();

    public LogroController(LogroService logroService) {
        this.logroService = logroService;
    }

    @GetMapping("/externo")
    public ResponseEntity<Map<String, Object>> obtenerLogroDesdeCPP() {
        String url = "http://localhost:5000/api/logros/test";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        return ResponseEntity.ok(response.getBody());
    }
}