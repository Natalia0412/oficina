package com.example.oficina.model.mechanic;

import com.example.oficina.model.mechanic.enums.Mechanic_Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_MECHANICS")
public class Mechanic {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @ElementCollection
    @CollectionTable(name = "specialties", joinColumns = @JoinColumn(name = "mechanic_id"), foreignKey = @ForeignKey(name = "UK_MECHANIC_SPECIALTY"))
    @Column(name = "specialty", nullable = false)
    private List<String> specialties;
    @Column(nullable = false)
    private LocalDate hiringDate;
    @Column(nullable = false)
    private Integer serviceFee;
    @Enumerated(EnumType.ORDINAL)
    private Mechanic_Status status;
}
