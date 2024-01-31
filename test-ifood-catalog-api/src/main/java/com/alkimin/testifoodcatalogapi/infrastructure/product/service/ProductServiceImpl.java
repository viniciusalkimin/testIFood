package com.alkimin.testifoodcatalogapi.infrastructure.product.service;

import com.alkimin.testifoodcatalogapi.application.product.service.ProductService;
import com.alkimin.testifoodcatalogapi.domain.product.Product;
import com.alkimin.testifoodcatalogapi.infrastructure.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Override
    public List<Product> findByOwnerId(String ownerId) {
        return productRepository.findByOwnerId(ownerId);
    }
}
