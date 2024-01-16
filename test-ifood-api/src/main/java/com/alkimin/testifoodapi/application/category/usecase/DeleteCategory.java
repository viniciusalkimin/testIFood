package com.alkimin.testifoodapi.application.category.usecase;

import com.alkimin.testifoodapi.application.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class DeleteCategory {

    private CategoryService categoryService;

    public Map<String, String> delete(String categoryId) {
        return categoryService.delete(categoryId);
    }
}
