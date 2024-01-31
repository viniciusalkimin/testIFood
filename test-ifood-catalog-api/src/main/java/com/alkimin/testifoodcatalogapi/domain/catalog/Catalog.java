package com.alkimin.testifoodcatalogapi.domain.catalog;

import com.alkimin.testifoodcatalogapi.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {

    private String ownerId;
    private Map<String, List<Product>> catalogItems;
}
