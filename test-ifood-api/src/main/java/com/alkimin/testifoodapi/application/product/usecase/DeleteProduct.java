package com.alkimin.testifoodapi.application.product.usecase;


import com.alkimin.testifoodapi.application.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class DeleteProduct {

    private ProductService productService;

    public Map<String, String> delete(String productId) {
        return productService.delete(productId);
    }
}
