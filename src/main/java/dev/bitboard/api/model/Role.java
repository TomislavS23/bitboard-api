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
@Table(name = "role")
public class Role {
    @Id
    @ColumnDefault("nextval('role_id_role_seq')")
    @Column(name = "id_role", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "role_type", length = 50)
    private String roleType;

}