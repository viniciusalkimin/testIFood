package com.alkimin.testifoodcatalogapi.application.product.service;

import com.alkimin.testifoodcatalogapi.domain.product.Product;

import java.util.List;

public interface ProductService {
    List<Product> findByOwnerId(String ownerId);
}
