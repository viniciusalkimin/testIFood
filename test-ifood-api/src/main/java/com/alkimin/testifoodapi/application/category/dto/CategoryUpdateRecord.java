package com.alkimin.testifoodapi.application.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryUpdateRecord(String categoryId, @NotBlank String title, @NotBlank String description) {
}
