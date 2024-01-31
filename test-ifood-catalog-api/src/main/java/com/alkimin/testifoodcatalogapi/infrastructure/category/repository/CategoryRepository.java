package com.alkimin.testifoodcatalogapi.infrastructure.category.repository;

import com.alkimin.testifoodcatalogapi.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryRepository, String> {

    List<Category> findByOwnerId(String ownerId);
}
