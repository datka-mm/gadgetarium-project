package com.example.gadgetariumproject.db.repository;

import com.example.gadgetariumproject.db.model.Category;
import com.example.gadgetariumproject.dto.response.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select new com.example.gadgetariumproject.dto.response.CategoryResponse(" +
            "c.id, " +
            "c.name) " +
            "from Category c where c.id = :id")
    CategoryResponse getCategoryResponse(Long id);

    @Query("select new com.example.gadgetariumproject.dto.response.CategoryResponse(" +
            "c.id, " +
            "c.name) " +
            "from Category c")
    List<CategoryResponse> getAllCategoryResponses();
}