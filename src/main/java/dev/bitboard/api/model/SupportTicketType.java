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
@Table(name = "support_ticket_type")
public class SupportTicketType {
    @Id
    @ColumnDefault("nextval('support_ticket_type_id_support_ticket_type_seq')")
    @Column(name = "id_support_ticket_type", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "ticket_type", length = 50)
    private String ticketType;

}