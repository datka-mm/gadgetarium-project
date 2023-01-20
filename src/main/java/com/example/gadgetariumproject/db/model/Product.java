package com.example.gadgetariumproject.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String price;

    private String vendorCode;

    private LocalDateTime createdAt;

    private String guarantee;

    @ElementCollection
    private List<String> images;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE})
    private Category category;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE})
    private SubCategory subCategory;

    @OneToOne(cascade = {ALL})
    private Description description;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE})
    private Brand brand;

    @OneToMany(cascade = {ALL})
    private List<Comment> comment;
}
