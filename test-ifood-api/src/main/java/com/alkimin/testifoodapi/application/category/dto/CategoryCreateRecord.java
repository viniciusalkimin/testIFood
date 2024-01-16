package com.alkimin.testifoodapi.application.category.dto;

import jakarta.validation.constraints.NotEmpty;

public record CategoryCreateRecord(@NotEmpty String title, @NotEmpty String description, @NotEmpty String ownerId) {
}
