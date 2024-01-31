package com.alkimin.testifoodcatalogapi.domain.product;

import com.alkimin.testifoodcatalogapi.domain.category.Category;
import com.alkimin.testifoodcatalogapi.domain.user.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Setter
    private String title;
    @Setter
    private String description;
    @Setter
    private BigDecimal price;
    @Setter
    private Category category;
    private User owner;

}
