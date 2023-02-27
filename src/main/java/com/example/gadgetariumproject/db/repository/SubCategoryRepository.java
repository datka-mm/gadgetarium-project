package com.example.gadgetariumproject.db.repository;

import com.example.gadgetariumproject.db.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}