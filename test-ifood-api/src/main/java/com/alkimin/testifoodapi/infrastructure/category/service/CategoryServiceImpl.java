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
        if (!categoryUpdate.title().isEmpty()) {
            category.setTitle(categoryUpdate.title());
        }
        if (!categoryUpdate.description().isEmpty()) {
            category.setDescription(categoryUpdate.description());
        }
        categoryRepository.save(category);
        return new CategoryUpdatedRecord(category.getId());
    }
}
