package dev.bitboard.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "thread")
public class Thread {
    @Id
    @ColumnDefault("nextval('thread_id_thread_seq')")
    @Column(name = "id_thread", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;

    @Size(max = 500)
    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "total_upvotes")
    private Integer totalUpvotes;

    @Column(name = "total_downvotes")
    private Integer totalDownvotes;

    @Column(name = "number_of_posts")
    private Integer numberOfPosts;

    @ColumnDefault("false")
    @Column(name = "locked")
    private Boolean locked;

}