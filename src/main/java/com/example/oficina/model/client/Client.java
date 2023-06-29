package com.example.oficina.model.client;

import com.example.oficina.model.car.Car;
import com.example.oficina.model.client.enums.Client_Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_CLIENTS")
public class Client implements Serializable, UserDetails {
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
    private String name;
    @Column(nullable = false)
    private String cpfCnpj;
    @Enumerated(EnumType.ORDINAL)
    private Client_Type client_type;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String neighbourhood;
    @Column(nullable = false)
    private String city;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    public Client removeCar(Car car) {
        cars.remove(car);
        car.setClient(null);
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
