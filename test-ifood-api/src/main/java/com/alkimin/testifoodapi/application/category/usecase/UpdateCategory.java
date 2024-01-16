package com.alkimin.testifoodapi.application.category.usecase;

import com.alkimin.testifoodapi.application.category.service.CategoryService;
import com.alkimin.testifoodapi.application.category.dto.CategoryUpdateRecord;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryUpdatedRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateCategory {

    private CategoryService categoryService;
    public CategoryUpdatedRecord update(CategoryUpdateRecord categoryUpdate) {
        return categoryService.update(categoryUpdate);
    }
}
