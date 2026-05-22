package com.ws101.ubas.ecommerceapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stockQuantity;
}