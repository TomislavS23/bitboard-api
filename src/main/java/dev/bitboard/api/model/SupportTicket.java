package dev.bitboard.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "support_ticket")
public class SupportTicket {
    @Id
    @ColumnDefault("nextval('support_ticket_id_support_ticket_seq')")
    @Column(name = "id_support_ticket", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "unique_id", length = 50)
    private String uniqueId;

    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "content", length = Integer.MAX_VALUE)
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_support_ticket_type")
    private dev.bitboard.api.model.SupportTicketType idSupportTicketType;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private dev.bitboard.api.model.User idUser;

}