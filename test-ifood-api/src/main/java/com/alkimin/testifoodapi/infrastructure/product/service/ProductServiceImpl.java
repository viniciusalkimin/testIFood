package com.alkimin.testifoodapi.infrastructure.product.service;

import com.alkimin.testifoodapi.application.category.exception.CategoryNotFoundException;
import com.alkimin.testifoodapi.application.product.dto.ProductCreateRecord;
import com.alkimin.testifoodapi.application.product.dto.ProductUpdateRecord;
import com.alkimin.testifoodapi.application.product.dto.ProductUpdatedRecord;
import com.alkimin.testifoodapi.application.product.exception.ProductNotFoundException;
import com.alkimin.testifoodapi.application.product.service.ProductService;
import com.alkimin.testifoodapi.domain.product.Product;
import com.alkimin.testifoodapi.infrastructure.category.dto.CatalogPublishRecord;
import com.alkimin.testifoodapi.infrastructure.category.repository.CategoryRepository;
import com.alkimin.testifoodapi.infrastructure.localstack.sqs.service.SQSPublisher;
import com.alkimin.testifoodapi.infrastructure.product.dto.ProductCreatedRecord;
import com.alkimin.testifoodapi.infrastructure.product.repository.ProductRepository;
import com.alkimin.testifoodapi.infrastructure.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private SQSPublisher sqsPublisher;
    private ObjectMapper mapper;

    @Override
    public ProductCreatedRecord create(ProductCreateRecord productCreate) {
        var owner = userRepository.findById(productCreate.ownerId()).get();
        var category = categoryRepository.findById(productCreate.categoryId()).orElseThrow(() -> new CategoryNotFoundException("Category informed do not exists!"));
        var product = Product.builder().title(productCreate.title())
                .description(productCreate.description()).price(productCreate.price())
                .category(category).owner(owner).build();
        var productSaved = productRepository.save(product);
        sqsPublisher.publishEvent(mapper.valueToTree(new CatalogPublishRecord(owner.getId())));
        return new ProductCreatedRecord(productSaved.getId(), productSaved.getTitle());
    }

    @Override
    public ProductUpdatedRecord update(ProductUpdateRecord productUpdate) {
        var product = productRepository.findById(productUpdate.productId()).orElseThrow(() -> new ProductNotFoundException("Product informed do not exists!"));
        if (!Objects.equals(productUpdate.title(), product.getTitle())) {
            product.setTitle(productUpdate.title());
        }
        if (!Objects.equals(productUpdate.description(), product.getDescription())) {
            product.setDescription(productUpdate.description());
        }
        if (!Objects.equals(productUpdate.price(), product.getPrice())) {
            product.setPrice(productUpdate.price());
        }
        if (!Objects.equals(productUpdate.categoryId(), product.getCategory().getId())) {
            var category = categoryRepository.findById(productUpdate.categoryId()).orElseThrow(() -> new CategoryNotFoundException("Category informed do not exists!"));
            product.setCategory(category);
        }
        var productUpdated = productRepository.save(product);
        var ownerId = product.getOwner().getId();
        sqsPublisher.publishEvent(mapper.valueToTree(new CatalogPublishRecord(ownerId)));
        return new ProductUpdatedRecord(productUpdated.getId(), productUpdated.getTitle());
    }

    @Override
    public HashMap<String, String> delete(String productId) {
        var ownerId = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product informed do not exists!")).getOwner().getId();
        productRepository.deleteById(productId);
        sqsPublisher.publishEvent(mapper.valueToTree(new CatalogPublishRecord(ownerId)));
        var map = new HashMap<String, String>();
        map.put("productId", productId);
        return map;
    }
}
