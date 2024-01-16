package com.alkimin.testifoodapi.infrastructure.product;

import com.alkimin.testifoodapi.application.product.dto.ProductCreateRecord;
import com.alkimin.testifoodapi.application.product.dto.ProductUpdateRecord;
import com.alkimin.testifoodapi.application.product.dto.ProductUpdatedRecord;
import com.alkimin.testifoodapi.application.product.usecase.CreateProduct;
import com.alkimin.testifoodapi.application.product.usecase.DeleteProduct;
import com.alkimin.testifoodapi.application.product.usecase.UpdateProduct;
import com.alkimin.testifoodapi.infrastructure.product.dto.ProductCreatedRecord;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("${application.context-path}/products")
public class ProductController {

    private CreateProduct createProduct;

    private UpdateProduct updateProduct;

    private DeleteProduct deleteProduct;

    @PostMapping
    public ResponseEntity<ProductCreatedRecord> create(@RequestBody @Valid ProductCreateRecord productCreate) {
        return ResponseEntity.ok().body(createProduct.create(productCreate));
    }

    @PutMapping
    public ResponseEntity<ProductUpdatedRecord> update(@RequestBody @Valid ProductUpdateRecord productUpdate) {
        return ResponseEntity.ok().body(updateProduct.update(productUpdate));
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> delete(@Param("productId") String productId) {
        return ResponseEntity.ok().body(deleteProduct.delete(productId));
    }
}
