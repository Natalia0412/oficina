package com.example.oficina.model.car;

import com.example.oficina.model.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_CARS")
public class Car implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name= "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(nullable = false)
    private UUID licensePlate;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false, name="car_year")
    private Integer year;
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    private String color;
    @ManyToOne()
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "UK_CAR_CLIENT"))
    @JsonIgnore
    private Client client;
}
