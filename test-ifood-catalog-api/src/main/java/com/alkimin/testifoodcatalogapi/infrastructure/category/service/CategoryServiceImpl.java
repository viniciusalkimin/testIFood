package com.alkimin.testifoodcatalogapi.infrastructure.category.service;

import com.alkimin.testifoodcatalogapi.application.category.service.CategoryService;
import com.alkimin.testifoodcatalogapi.domain.category.Category;
import com.alkimin.testifoodcatalogapi.infrastructure.category.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findByOwnerId(String ownerId) {
        return categoryRepository.findByOwnerId(ownerId);
    }
}
