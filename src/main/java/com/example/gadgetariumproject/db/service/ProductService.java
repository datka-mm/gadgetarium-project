package com.example.gadgetariumproject.db.service;

import com.example.gadgetariumproject.dto.request.ProductRequest;
import com.example.gadgetariumproject.dto.response.ProductResponse;
import com.example.gadgetariumproject.dto.response.SimpleResponse;
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


    }

    public SimpleResponse deleteProductById(Long id) {

    }
}
