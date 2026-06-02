package com.ws101.Ubas.EcommerceApi.service;

import com.ws101.Ubas.EcommerceApi.model.Product;
import com.ws101.Ubas.EcommerceApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(@NonNull Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(@NonNull Long id) {
        return productRepository.findById(id);
    }
}