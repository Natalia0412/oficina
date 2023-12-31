package com.example.oficina.model.services;

import com.example.oficina.model.car.Car;
import com.example.oficina.model.client.Client;
import com.example.oficina.model.mechanic.Mechanic;
import com.example.oficina.model.part.Part;
import com.example.oficina.model.services.enums.Service_Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_SERVICES")
public class Services implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name= "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "UK_SERVICES_CLIENT"), referencedColumnName = "id")
    private Client client;
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "UK_SERVICES_CAR"), referencedColumnName = "id")
    private Car car;
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "mechanic_id", foreignKey = @ForeignKey(name = "UK_SERVICES_MECHANIC"), referencedColumnName = "id")
    private Mechanic mechanic;
    @Column(nullable = false)
    private LocalDate serviceEstimatedDeliveryDate;
    @Column(nullable = false)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", foreignKey = @ForeignKey(name = "UK_SERVICES_PART"))
    private List<Part> parts = new ArrayList<>();
    @Enumerated(EnumType.ORDINAL)
    private Service_Status status;
}
