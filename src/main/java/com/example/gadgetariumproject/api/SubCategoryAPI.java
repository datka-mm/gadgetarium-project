package com.example.gadgetariumproject.api;

import com.example.gadgetariumproject.db.model.SubCategory;
import com.example.gadgetariumproject.db.service.SubCategoryService;
import com.example.gadgetariumproject.dto.request.SubCategoryRequest;
import com.example.gadgetariumproject.dto.request.UpdateRequest;
import com.example.gadgetariumproject.dto.response.SimpleResponse;
import com.example.gadgetariumproject.dto.response.SubCategoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sub-category")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "SubCategory API", description = "All endpoints of subCategories")
@PreAuthorize("hasRole('ADMIN')")
public class SubCategoryAPI {

    private final SubCategoryService service;

    @Operation(summary = "Add sub category", description = "Add new sub category")
    @PostMapping
    public SubCategoryResponse addSubCategory(@RequestBody SubCategoryRequest request) {
        return service.addSubCategory(request);
    }

    @Operation(summary = "Get sub category", description = "Get sub category by id")
    @GetMapping("/{id}")
    public SubCategoryResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Update sub category", description = "Update sub category name")
    @PutMapping
    public SubCategoryResponse update(@RequestBody UpdateRequest request) {
        return service.update(request);
    }

    @Operation(summary = "Get all sub category", description = "Get all sub category by category id")
    @GetMapping("/{categoryId}")
    public List<SubCategoryResponse> getAll(@PathVariable Long categoryId) {
        return service.getAll(categoryId);
    }

    @Operation(summary = "Delete sub category", description = "Delete sub category id")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
