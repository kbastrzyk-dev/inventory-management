package com.allegro.intern.inventorymanagement.repository;

import com.allegro.intern.inventorymanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // This automatically writes the SQL WHERE category = ?
    List<Product> findByCategory(String category);

    // This automatically writes the SQL WHERE price BETWEEN ? AND ?
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}