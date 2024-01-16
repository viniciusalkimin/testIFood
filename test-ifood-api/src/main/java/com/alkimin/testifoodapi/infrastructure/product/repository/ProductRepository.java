package com.alkimin.testifoodapi.infrastructure.product.repository;

import com.alkimin.testifoodapi.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
