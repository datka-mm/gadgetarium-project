package com.example.gadgetariumproject.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "favorites")
@Getter
@Setter
@NoArgsConstructor
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {DETACH, REFRESH, MERGE})
    private Product product;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE})
    private User user;
}
