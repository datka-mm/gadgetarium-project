package com.example.gadgetariumproject.db.model;

import com.example.gadgetariumproject.dto.request.SubCategoryRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "sub_categories")
@Getter
@Setter
@NoArgsConstructor
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = {MERGE, REFRESH, DETACH})
    private Category category;

    public SubCategory(SubCategoryRequest request) {
        this.name = request.getName();
    }
}
