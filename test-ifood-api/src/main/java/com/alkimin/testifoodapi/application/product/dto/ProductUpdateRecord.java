package com.alkimin.testifoodapi.application.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record ProductUpdateRecord(@NotEmpty String productId, @NotBlank String title, @NotBlank String description, BigDecimal price, @NotBlank String categoryId) {
}
