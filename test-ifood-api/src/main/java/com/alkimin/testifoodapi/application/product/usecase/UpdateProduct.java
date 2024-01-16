package com.alkimin.testifoodapi.application.product.usecase;

import com.alkimin.testifoodapi.application.product.dto.ProductUpdateRecord;
import com.alkimin.testifoodapi.application.product.dto.ProductUpdatedRecord;
import com.alkimin.testifoodapi.application.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateProduct {

    private ProductService productService;

    public ProductUpdatedRecord update(ProductUpdateRecord productUpdate) {
        return productService.update(productUpdate);
    }
}
