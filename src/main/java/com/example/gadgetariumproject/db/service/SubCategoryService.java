package com.example.gadgetariumproject.db.service;

import com.example.gadgetariumproject.db.model.Category;
import com.example.gadgetariumproject.db.model.SubCategory;
import com.example.gadgetariumproject.db.repository.CategoryRepository;
import com.example.gadgetariumproject.db.repository.SubCategoryRepository;
import com.example.gadgetariumproject.dto.request.SubCategoryRequest;
import com.example.gadgetariumproject.dto.request.UpdateRequest;
import com.example.gadgetariumproject.dto.response.SimpleResponse;
import com.example.gadgetariumproject.dto.response.SubCategoryResponse;
import com.example.gadgetariumproject.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;

    //if Category's and SubCategory's relationship is bidirectional must add method
    public SubCategoryResponse addSubCategory(SubCategoryRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(
                () -> new NotFoundException("Category with id: " + request.getCategoryId() + " not found!")
        );

        SubCategory subCategory = new SubCategory(request);
        return subCategoryRepository.getSubCategoryResponse(subCategory.getId());
    }

    public SubCategoryResponse getById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("SubCategory with id: " + id + " not found!")
        );

        return subCategoryRepository.getSubCategoryResponse(subCategory.getId());
    }

    public SubCategoryResponse update(UpdateRequest request) {
        SubCategory subCategory = subCategoryRepository.findById(request.getId()).orElseThrow(
                () -> new NotFoundException("SubCategory with id: " + request.getId() + " not found!")
        );

        if (!subCategory.getName().equals(request.getName())) {
            subCategory.setName(request.getName());
        }

        return subCategoryRepository.getSubCategoryResponse(subCategory.getId());
    }

    public SimpleResponse deleteById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("SubCategory with id: " + id + " not found!")
        );

        subCategoryRepository.deleteById(id);
        return new SimpleResponse("SubCategory with id: " + id + " successfully deleted!", "OK");
    }
}
