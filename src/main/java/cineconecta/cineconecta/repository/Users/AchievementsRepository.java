package cineconecta.cineconecta.repository.Users;

import cineconecta.cineconecta.model.Users.Achievements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AchievementsRepository extends JpaRepository<Achievements, UUID> {}
