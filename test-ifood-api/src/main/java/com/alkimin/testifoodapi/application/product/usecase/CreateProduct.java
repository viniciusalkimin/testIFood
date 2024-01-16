package com.alkimin.testifoodapi.application.product.usecase;

import com.alkimin.testifoodapi.application.product.dto.ProductCreateRecord;
import com.alkimin.testifoodapi.application.product.service.ProductService;
import com.alkimin.testifoodapi.infrastructure.product.dto.ProductCreatedRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateProduct {

    private ProductService productService;

    public ProductCreatedRecord create (ProductCreateRecord productCreate) {
        return productService.create(productCreate);
    }


}
