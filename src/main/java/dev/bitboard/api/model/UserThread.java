package dev.bitboard.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "user_thread")
public class UserThread {
    @Id
    @ColumnDefault("nextval('user_thread_id_user_thread_seq')")
    @Column(name = "id_user_thread", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private dev.bitboard.api.model.User idUser;

    @ManyToOne
    @JoinColumn(name = "id_thread")
    private Thread idThread;

}