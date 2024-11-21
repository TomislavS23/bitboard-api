package dev.bitboard.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "statistics")
public class Statistic {
    @Id
    @ColumnDefault("nextval('statistics_id_statistics_seq')")
    @Column(name = "id_statistics", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private dev.bitboard.api.model.User idUser;

    @Column(name = "number_of_topics")
    private Integer numberOfTopics;

    @Column(name = "total_upvotes")
    private Integer totalUpvotes;

    @Column(name = "total_downvotes")
    private Integer totalDownvotes;

}