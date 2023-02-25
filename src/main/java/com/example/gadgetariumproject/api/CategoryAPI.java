package com.example.gadgetariumproject.api;

import com.example.gadgetariumproject.db.service.CategoryService;
import com.example.gadgetariumproject.dto.request.CategoryRequest;
import com.example.gadgetariumproject.dto.request.UpdateRequest;
import com.example.gadgetariumproject.dto.response.CategoryResponse;
import com.example.gadgetariumproject.dto.response.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CategoryResponse updateCategory(@RequestBody UpdateRequest request) {
        return service.updateCategoryName(request);
    }

    @Operation(summary = "Get category", description = "Get category by id")
    @GetMapping("/{id}")
    public CategoryResponse getCategory(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @Operation(summary = "Delete category", description = "Delete category by id")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteCategory(@PathVariable Long id) {
        return service.deleteCategory(id);
    }

    @Operation(summary = "Get categories", description = "Get all categories")
    @GetMapping("/categories")
    public List<CategoryResponse> getAllCategories() {
        return service.getAllCategory();
    }

}
