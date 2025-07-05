package cineconecta.cineconecta.controllers.Users;

import cineconecta.cineconecta.controllers.Fimls.CineResponse;
import cineconecta.cineconecta.model.Users.Cinephile;
import cineconecta.cineconecta.service.User.UserServices;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.util.function.ThrowingSupplier;
import org.springframework.web.bind.annotation.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String message;
}
