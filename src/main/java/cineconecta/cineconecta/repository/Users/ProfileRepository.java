package cineconecta.cineconecta.repository.Users;

import cineconecta.cineconecta.model.Users.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {}
