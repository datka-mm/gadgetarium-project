package com.example.gadgetariumproject.db.repository;

import com.example.gadgetariumproject.db.model.SubCategory;
import com.example.gadgetariumproject.dto.response.SubCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

//    @Query("select new com.example.gadgetariumproject.dto.response.SubCategoryResponse(" +
//            "s.id, " +
//            "s.name)" +
//            "from SubCategory s where s.")
//    List<SubCategoryResponse> getAll(Long categoryId);

    @Query("select new com.example.gadgetariumproject.dto.response.SubCategoryResponse(" +
            "s.id, " +
            "s.name) " +
            "from SubCategory s where s.id = :id")
    SubCategoryResponse getSubCategoryResponse(Long id);

    @Query("select new com.example.gadgetariumproject.dto.response.SubCategoryResponse(" +
            "s.id, " +
            "s.name) " +
            "from SubCategory s where s.category.id = :id")
    List<SubCategoryResponse> getAllSubCategoryResponseByCategoryId(Long id);
}