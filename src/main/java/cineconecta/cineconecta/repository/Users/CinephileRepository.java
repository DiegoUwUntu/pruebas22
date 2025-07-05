package cineconecta.cineconecta.repository.Users;

import cineconecta.cineconecta.model.Users.Cinephile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CinephileRepository extends JpaRepository<Cinephile, UUID> {}
