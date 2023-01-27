package com.example.gadgetariumproject.db.service;

import com.example.gadgetariumproject.db.model.Product;
import com.example.gadgetariumproject.db.repository.ProductRepository;
import com.example.gadgetariumproject.dto.request.ProductRequest;
import com.example.gadgetariumproject.dto.response.ProductResponse;
import com.example.gadgetariumproject.dto.response.SimpleResponse;
import com.example.gadgetariumproject.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse addProduct(ProductRequest productRequest) {

    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product with id: " + id + " not found!")
        );

        return new ProductResponse();
    }

    public SimpleResponse deleteProductById(Long id) {

    }
}
