package com.allegro.intern.inventorymanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "products") // Maps this class to a table called 'products' in Postgres
@Data // Lombok: Generates Getters, Setters, toString automatically
@NoArgsConstructor // Lombok: Creates a default constructor (required by JPA)
@AllArgsConstructor // Lombok: Creates a constructor with all fields
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // This is the Primary Key (Auto-number)

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(unique = true, nullable = false)
    private String sku; // Stock Keeping Unit (Unique Identifier)

    private BigDecimal price; // Standard for currency (prevents rounding errors)

    private Integer stockQuantity;

    private String category;
}