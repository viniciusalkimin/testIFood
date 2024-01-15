package com.alkimin.testifoodapi.infrastructure.category.repository;

import com.alkimin.testifoodapi.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
