package com.alkimin.testifoodapi.infrastructure.category;


import com.alkimin.testifoodapi.application.category.dto.CategoryCreateRecord;
import com.alkimin.testifoodapi.application.category.usecase.DeleteCategory;
import com.alkimin.testifoodapi.application.category.usecase.UpdateCategory;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryCreatedRecord;
import com.alkimin.testifoodapi.application.category.usecase.CreateCategory;
import com.alkimin.testifoodapi.application.category.dto.CategoryUpdateRecord;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryUpdatedRecord;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("${application.context-path}/categories")
public class CategoryController {

    private CreateCategory createCategory;

    private UpdateCategory updateCategory;

    private DeleteCategory deleteCategory;

    @PostMapping
    public ResponseEntity<CategoryCreatedRecord> create(@RequestBody @Valid CategoryCreateRecord categoryCreateRecord) {
        return ResponseEntity.ok().body(createCategory.create(categoryCreateRecord));
    }

    @PutMapping
    public ResponseEntity<CategoryUpdatedRecord> update(@RequestBody @Valid CategoryUpdateRecord categoryUpdate) {
        return ResponseEntity.ok().body(updateCategory.update(categoryUpdate));
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> delete(@Param("categoryId") String categoryId) {
        return ResponseEntity.ok().body(deleteCategory.delete(categoryId));
    }
}
