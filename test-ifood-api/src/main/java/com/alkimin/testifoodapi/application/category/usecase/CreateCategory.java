package com.alkimin.testifoodapi.application.category.usecase;


import com.alkimin.testifoodapi.application.category.dto.CategoryCreateRecord;
import com.alkimin.testifoodapi.application.category.service.CategoryService;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryCreatedRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateCategory {

    private CategoryService categoryService;

    public CategoryCreatedRecord create(CategoryCreateRecord categoryCreate){
         return categoryService.createCategory(categoryCreate);
    }
}
