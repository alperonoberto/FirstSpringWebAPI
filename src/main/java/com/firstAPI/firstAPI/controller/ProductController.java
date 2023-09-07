package com.firstAPI.firstAPI.controller;

import com.firstAPI.firstAPI.controller.model.ProductID;
import com.firstAPI.firstAPI.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product) {
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();

        result.add(new Product("1", "Product1", new BigDecimal("199.25")));
        result.add(new Product("2", "Product2", new BigDecimal("287.50")));
        result.add(new Product("3", "Product3", new BigDecimal("99.75")));

        return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id) {
        System.out.println(id);
        return new Product("555", "GetById test", new BigDecimal("999.99"));
    }

    @PatchMapping("/product")
    public ResponseEntity<Product> patchProduct(@RequestBody final Product product) {
        System.out.println(product);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable final String id) {
        System.out.println(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Product(id, "Delete test", new BigDecimal("321.66")));
    }
}
