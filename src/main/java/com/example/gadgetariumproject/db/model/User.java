package com.example.gadgetariumproject.db.model;

import com.example.gadgetariumproject.dto.request.SighUpRequest;
import com.example.gadgetariumproject.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = {DETACH, REFRESH, MERGE})
    private List<Favorite> favorites;

    public User(SighUpRequest sighUpRequest) {
        this.firstName = sighUpRequest.getFirstName();
        this.lastName = sighUpRequest.getLastName();
        this.phoneNumber = sighUpRequest.getPhoneNumber();
        this.email = sighUpRequest.getEmail();
    }
}
