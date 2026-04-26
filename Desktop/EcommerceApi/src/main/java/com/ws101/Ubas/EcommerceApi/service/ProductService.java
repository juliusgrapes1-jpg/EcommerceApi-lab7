package com.ws101.ubas.ecommerceapi.service;

import com.ws101.ubas.ecommerceapi.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    // In-memory data storage [cite: 1, 22]
    private List<Product> productList = new ArrayList<>();

    public ProductService() {
        // Initialize with 10 sample products [cite: 22]
        for (int i = 1; i <= 10; i++) {
            productList.add(new Product(String.valueOf(i), "Product " + i, "Description " + i, 10.0 * i, "Electronics", 10));
        }
    }

    /**
     * Retrieves all products[cite: 22].
     * @return List of products
     */
    public List<Product> getAllProducts() {
        return productList;
    }

    /**
     * Finds a product by ID[cite: 22].
     * @param id the unique identifier
     * @return Optional containing the product if found
     */
    public Optional<Product> getProductById(String id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}