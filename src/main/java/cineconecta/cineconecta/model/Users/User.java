package cineconecta.cineconecta.model.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = true)
    Profile profile;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name="updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @Column(name="active", nullable = false)
    private boolean active = true;
}
