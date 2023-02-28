package com.example.gadgetariumproject.db.service;

import com.example.gadgetariumproject.db.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository repository;
}
