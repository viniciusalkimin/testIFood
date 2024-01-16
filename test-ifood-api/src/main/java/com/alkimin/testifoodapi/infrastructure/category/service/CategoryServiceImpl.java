package com.alkimin.testifoodapi.infrastructure.category.service;

import com.alkimin.testifoodapi.application.category.dto.CategoryCreateRecord;
import com.alkimin.testifoodapi.application.category.exception.CategoryNotFoundException;
import com.alkimin.testifoodapi.application.category.service.CategoryService;
import com.alkimin.testifoodapi.application.user.exception.OwnerNotFoundException;
import com.alkimin.testifoodapi.domain.category.Category;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryCreatedRecord;
import com.alkimin.testifoodapi.application.category.dto.CategoryUpdateRecord;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryUpdatedRecord;
import com.alkimin.testifoodapi.infrastructure.category.repository.CategoryRepository;
import com.alkimin.testifoodapi.infrastructure.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    @Override
    public CategoryCreatedRecord createCategory(CategoryCreateRecord categoryCreate) {
        var owner = userRepository.findById(categoryCreate.ownerId()).orElseThrow(() -> new OwnerNotFoundException("Owner informed do not exists!"));
        var category = Category.builder().title(categoryCreate.title())
                .description(categoryCreate.description())
                .owner(owner).build();
        Category categorySaved = categoryRepository.save(category);
        return new CategoryCreatedRecord(categorySaved.getId(), categorySaved.getTitle(), owner.getId());
    }

    @Override
    public CategoryUpdatedRecord update(CategoryUpdateRecord categoryUpdate) {
        var category = categoryRepository.findById(categoryUpdate.categoryId()).orElseThrow(() -> new CategoryNotFoundException("Category informed do not exists!"));
        if (!Objects.equals(categoryUpdate.title(), category.getTitle())) {
            category.setTitle(categoryUpdate.title());
        }
        if (!Objects.equals(categoryUpdate.description(), category.getDescription())) {
            category.setDescription(categoryUpdate.description());
        }
        categoryRepository.save(category);
        return new CategoryUpdatedRecord(category.getId());
    }

    @Override
    public HashMap<String, String> delete(String categoryId) {
        categoryRepository.deleteById(categoryId);
        var map = new HashMap<String, String>();
        map.put("categoryId", categoryId);
        return map;
    }
}
