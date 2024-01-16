package com.alkimin.testifoodapi.application.product.service;

import com.alkimin.testifoodapi.application.product.dto.ProductCreateRecord;
import com.alkimin.testifoodapi.application.product.dto.ProductUpdateRecord;
import com.alkimin.testifoodapi.application.product.dto.ProductUpdatedRecord;
import com.alkimin.testifoodapi.infrastructure.product.dto.ProductCreatedRecord;

import java.util.HashMap;

public interface ProductService {
    ProductCreatedRecord create(ProductCreateRecord productCreate);

    ProductUpdatedRecord update(ProductUpdateRecord productUpdate);

    HashMap<String, String> delete(String productId);
}
