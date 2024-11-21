package dev.bitboard.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 500)
    @NotNull
    @Column(name = "hashed_password", nullable = false, length = 500)
    private String hashedPassword;

    @Size(max = 32)
    @NotNull
    @Column(name = "salt", nullable = false, length = 32)
    private String salt;

    @NotNull
    @ColumnDefault("600001")
    @Column(name = "iterations", nullable = false)
    private Integer iterations;

    @ColumnDefault("CURRENT_DATE")
    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne
    @ColumnDefault("1")
    @JoinColumn(name = "id_role")
    private Role idRole;

}