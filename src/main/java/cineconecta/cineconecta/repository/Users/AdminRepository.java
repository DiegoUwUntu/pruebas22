package cineconecta.cineconecta.repository.Users;

import cineconecta.cineconecta.model.Users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
