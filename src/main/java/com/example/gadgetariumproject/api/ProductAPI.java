package com.example.gadgetariumproject.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Product API", description = "All endpoints of product")
public class ProductAPI {

//    private final ProductService productService;
//
//    @Operation(summary = "Add product", description = "Add product")
//    @PostMapping
//    public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {
//        return productService.addProduct(productRequest);
//    }
//
//    @Operation(summary = "Get product", description = "Get product by id")
//    @GetMapping("/{id}")
//    public ProductResponse getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }


}
