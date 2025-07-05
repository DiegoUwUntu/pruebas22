package cineconecta.cineconecta.model.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "avatar", nullable = false)
    private String avatar = "https://cineconectav1.blob.core.windows.net/imagenes/base_profile.jpg";

    @Column(name = "bio", nullable = false)
    private String bio = "¡Hi! i'm a cinephile, welcome to my profile!";

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private User user;

    @OneToMany(mappedBy = "profile")
    private List<Achievements> achievements;
}