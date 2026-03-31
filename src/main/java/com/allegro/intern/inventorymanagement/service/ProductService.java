package com.allegro.intern.inventorymanagement.service;

import com.allegro.intern.inventorymanagement.model.Product;
import com.allegro.intern.inventorymanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // NEW FILTERING METHODS
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getProductsByPriceRange(BigDecimal min, BigDecimal max) {
        // Ensure these variable names match what you pass into the repository method
        return productRepository.findByPriceBetween(min, max);
    }
}