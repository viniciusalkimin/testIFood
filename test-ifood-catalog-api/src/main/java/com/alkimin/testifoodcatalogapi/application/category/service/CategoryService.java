package com.alkimin.testifoodcatalogapi.application.category.service;

import com.alkimin.testifoodcatalogapi.domain.category.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findByOwnerId(String ownerId);

}
