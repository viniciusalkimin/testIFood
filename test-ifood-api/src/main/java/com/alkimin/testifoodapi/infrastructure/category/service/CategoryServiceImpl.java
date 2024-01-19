package com.alkimin.testifoodapi.infrastructure.category.service;

import com.alkimin.testifoodapi.application.category.dto.CategoryCreateRecord;
import com.alkimin.testifoodapi.application.category.dto.CategoryUpdateRecord;
import com.alkimin.testifoodapi.application.category.exception.CategoryNotFoundException;
import com.alkimin.testifoodapi.application.category.service.CategoryService;
import com.alkimin.testifoodapi.application.user.exception.OwnerNotFoundException;
import com.alkimin.testifoodapi.domain.category.Category;
import com.alkimin.testifoodapi.infrastructure.category.dto.CatalogPublishRecord;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryCreatedRecord;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryUpdatedRecord;
import com.alkimin.testifoodapi.infrastructure.category.repository.CategoryRepository;
import com.alkimin.testifoodapi.infrastructure.localstack.sqs.service.SQSPublisher;
import com.alkimin.testifoodapi.infrastructure.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private UserRepository userRepository;
    private SQSPublisher sqsPublisher;

    @Override
    public CategoryCreatedRecord createCategory(CategoryCreateRecord categoryCreate) {
        var owner = userRepository.findById(categoryCreate.ownerId()).orElseThrow(() -> new OwnerNotFoundException("Owner informed do not exists!"));
        var category = Category.builder().title(categoryCreate.title())
                .description(categoryCreate.description())
                .owner(owner).build();
        Category categorySaved = categoryRepository.save(category);
        sqsPublisher.publishEvent(new CatalogPublishRecord(owner.getId()));
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
        var ownerId = category.getOwner().getId();
        sqsPublisher.publishEvent(new CatalogPublishRecord(ownerId));
        return new CategoryUpdatedRecord(category.getId());
    }

    @Override
    public HashMap<String, String> delete(String categoryId) {
        var ownerId = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category informed do not exists!")).getOwner().getId();
        categoryRepository.deleteById(categoryId);
        sqsPublisher.publishEvent(new CatalogPublishRecord(ownerId));
        var map = new HashMap<String, String>();
        map.put("categoryId", categoryId);
        return map;
    }
}
