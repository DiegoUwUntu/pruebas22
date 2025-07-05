package cineconecta.cineconecta.service.Films;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogroService {

    public String obtenerMensajeDesdeCService() {
        String url = "http://localhost:5000/api/logros/test";
        RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "Error al conectar con ServiceCPP: " + e.getMessage();
        }
    }
}