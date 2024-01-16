package com.alkimin.testifoodapi.application.product.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductCreateRecord(@NotEmpty String title, @NotEmpty String description, @NotNull BigDecimal price, @NotEmpty String categoryId, @NotEmpty String ownerId) {
}
