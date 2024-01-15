package com.alkimin.testifoodapi.domain.product;

import com.alkimin.testifoodapi.domain.category.Category;
import com.alkimin.testifoodapi.domain.user.User;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private Category category;
    private User ownerId;

}
