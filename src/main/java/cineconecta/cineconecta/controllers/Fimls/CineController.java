package cineconecta.cineconecta.controllers.Fimls;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.util.function.ThrowingSupplier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@Controller
@RequestMapping("/cine")
@RequiredArgsConstructor
public class CineController {

    @GetMapping("")
    public ResponseEntity<CineResponse> getAllCategory() {
        return handleRequestProcess(() -> CineResponse.builder().message("List of all categories").build());
    }


    private ResponseEntity<CineResponse> handleRequestProcess(ThrowingSupplier<CineResponse> supplier) {
        try {
            return ResponseEntity.ok(supplier.get());
        } catch (MessagingException e) {
            return ResponseEntity.status(500).body(CineResponse.builder().message("Error to send email").build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(CineResponse.builder().message("Internal Server Error: " + e ).build());
        }
    }
}
