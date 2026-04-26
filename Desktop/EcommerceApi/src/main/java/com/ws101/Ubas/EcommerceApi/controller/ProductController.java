package com.ws101.ubas.ecommerceapi.controller;

import com.ws101.ubas.ecommerceapi.model.Product;
import com.ws101.ubas.ecommerceapi.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products") // Base path [cite: 24]
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping // GET /api/v1/products [cite: 24]
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}") // GET /api/v1/products/{id} [cite: 24]
    public ResponseEntity<Product> getById(@PathVariable String id) {
        // Return 200 OK or 404 Not Found [cite: 29]
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}