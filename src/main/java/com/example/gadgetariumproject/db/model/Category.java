package com.example.gadgetariumproject.db.model;

import com.example.gadgetariumproject.dto.request.CategoryRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = {MERGE, REFRESH, DETACH, REMOVE})
    private List<SubCategory> subCategories;

    public Category(CategoryRequest request) {
        this.name = request.getName();
    }

    public void addSubCategory(SubCategory subCategory) {
        if (subCategories == null) {
            subCategories = new ArrayList<>();
        }
        subCategories.add(subCategory);
    }
}
