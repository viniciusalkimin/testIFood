package com.alkimin.testifoodcatalogapi.application.catalog.usecase;

import com.alkimin.testifoodcatalogapi.application.category.service.CategoryService;
import com.alkimin.testifoodcatalogapi.application.product.service.ProductService;
import com.alkimin.testifoodcatalogapi.domain.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class ProcessarCatalog {

    private CategoryService categoryService;

    private ProductService productService;

    public void execute(String ownerId) {
        var categories = categoryService.findByOwnerId(ownerId);
        var products = productService.findByOwnerId(ownerId);
        Map<String, List<Product>> catalog = new HashMap<>();
        categories.forEach(categorie -> {
            var listProductCategorie = products.stream().filter(product -> product.getCategory().equals(categorie)).toList();
            catalog.put(categorie.getTitle(), listProductCategorie);
        });
    }
}
