package com.alkimin.testifoodapi.infrastructure.category;


import com.alkimin.testifoodapi.application.category.dto.CategoryCreateRecord;
import com.alkimin.testifoodapi.application.category.usecase.UpdateCategory;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryCreatedRecord;
import com.alkimin.testifoodapi.application.category.usecase.CreateCategory;
import com.alkimin.testifoodapi.application.category.dto.CategoryUpdateRecord;
import com.alkimin.testifoodapi.infrastructure.category.dto.CategoryUpdatedRecord;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${application.context-path}/categories")
public class CategoryController {

    private CreateCategory createCategory;

    private UpdateCategory updateCategory;

    @PostMapping
    public ResponseEntity<CategoryCreatedRecord> create(@RequestBody CategoryCreateRecord categoryCreateRecord) {
        return ResponseEntity.ok().body(createCategory.create(categoryCreateRecord));
    }

    @PutMapping
    public ResponseEntity<CategoryUpdatedRecord> update(@RequestBody CategoryUpdateRecord categoryUpdate) {
        return ResponseEntity.ok().body(updateCategory.update(categoryUpdate));
    }
}
