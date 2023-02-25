package com.example.gadgetariumproject.db.service;

import com.example.gadgetariumproject.db.model.Category;
import com.example.gadgetariumproject.db.repository.CategoryRepository;
import com.example.gadgetariumproject.dto.request.CategoryRequest;
import com.example.gadgetariumproject.dto.response.CategoryResponse;
import com.example.gadgetariumproject.dto.response.SimpleResponse;
import com.example.gadgetariumproject.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Category with id: " + id + " not found!")
        );

        return categoryRepository.getCategoryResponse(id);
    }

    public CategoryResponse addNewCategory(CategoryRequest request) {
        Category category = new Category(request);
        Category save = categoryRepository.save(category);
        return categoryRepository.getCategoryResponse(save.getId());
    }

    public SimpleResponse deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Category with id: " + id + " not found!")
        );

        categoryRepository.delete(category);
        return new SimpleResponse(
                "Category with id: " + id + " successfully deleted!",
                "OK"
        );
    }



}
