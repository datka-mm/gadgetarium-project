package com.example.gadgetariumproject.api;

import com.example.gadgetariumproject.db.model.SubCategory;
import com.example.gadgetariumproject.db.service.SubCategoryService;
import com.example.gadgetariumproject.dto.request.SubCategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sub-category")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "SubCategory API", description = "All endpoints of subCategories")
public class SubCategoryAPI {

    private final SubCategoryService service;

    @Operation(summary = "Add sub category", description = "Add new sub category")
    @PostMapping
    public SubCategoryResponse addSubCategory(@RequestBody SubCategoryRequest request) {
        return service.addSubCategory(request);
    }


}
