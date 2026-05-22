package com.ws101.Ubas.EcommerceApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // This replaces the String id for the database

    private String name;
    private String description;
    private double price;
    private String category;
    private int stockQuantity;
}