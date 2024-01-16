package com.alkimin.testifoodapi.application.category.service;

import com.alkimin.testifoodapi.application.category.dto.CategoryCreateRecord;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryCreatedRecord;
import com.alkimin.testifoodapi.application.category.dto.CategoryUpdateRecord;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryUpdatedRecord;

import java.util.HashMap;

public interface CategoryService {
    CategoryCreatedRecord createCategory(CategoryCreateRecord categoryCreate);

    CategoryUpdatedRecord update(CategoryUpdateRecord categoryUpdate);

    HashMap<String, String> delete(String categoryId);
}
