package com.example.gadgetariumproject.api;

import com.example.gadgetariumproject.db.service.CategoryService;
import com.example.gadgetariumproject.dto.request.CategoryRequest;
import com.example.gadgetariumproject.dto.request.UpdateRequest;
import com.example.gadgetariumproject.dto.response.CategoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/category")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Category API", description = "All endpoints of category")
@PreAuthorize("hasRole('ADMIN')")
public class CategoryAPI {

    private final CategoryService service;

    @Operation(summary = "Create category", description = "Create new description")
    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        return service.addNewCategory(request);
    }

    @Operation(summary = "Update category name", description = "Update category name")
    @PutMapping
    public CategoryService updateCategory(@RequestBody UpdateRequest request) {
        return service.updateCategoryName(request);
    }
}
