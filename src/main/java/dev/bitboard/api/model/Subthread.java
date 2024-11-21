package dev.bitboard.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "subthread")
public class Subthread {
    @Id
    @ColumnDefault("nextval('subthread_id_subthread_seq')")
    @Column(name = "id_subthread", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "content", length = Integer.MAX_VALUE)
    private String content;

    @Column(name = "total_upvotes")
    private Integer totalUpvotes;

    @Column(name = "total_downvotes")
    private Integer totalDownvotes;

    @ColumnDefault("false")
    @Column(name = "locked")
    private Boolean locked;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private dev.bitboard.api.model.User idUser;

    @ManyToOne
    @JoinColumn(name = "id_thread")
    private dev.bitboard.api.model.Thread idThread;

}