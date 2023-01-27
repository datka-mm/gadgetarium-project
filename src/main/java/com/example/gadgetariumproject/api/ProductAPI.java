package com.example.gadgetariumproject.api;

import com.example.gadgetariumproject.db.service.ProductService;
import com.example.gadgetariumproject.dto.request.ProductRequest;
import com.example.gadgetariumproject.dto.response.ProductResponse;
import com.example.gadgetariumproject.dto.response.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Product API", description = "All endpoints of product")
public class ProductAPI {

    private final ProductService productService;

//    @Operation(summary = "Add product", description = "Add product")
//    @PostMapping
//    public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {
//        return productService.addProduct(productRequest);
//    }

    @Operation(summary = "Get product", description = "Get product by id")
    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @Operation(summary = "Delete product", description = "Delete product by id")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteProduct(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }

}
