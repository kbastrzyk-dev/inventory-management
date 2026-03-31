package com.allegro.intern.inventorymanagement.controller;

import com.allegro.intern.inventorymanagement.model.Product;
import com.allegro.intern.inventorymanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

import java.util.List;

@RestController
@RequestMapping("/api/products") // This is the "Base URL" for all endpoints here
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET all products: http://localhost:8080/api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    // Filter by category: http://localhost:8080/api/products/filter/category?name=Electronics
    @GetMapping("/filter/category")
    public List<Product> filterByCategory(@RequestParam String name) {
        return productService.getProductsByCategory(name);
    }

    // Filter by price: http://localhost:8080/api/products/filter/price?min=500&max=3000
    @GetMapping("/filter/price")
    public List<Product> filterByPrice(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return productService.getProductsByPriceRange(min, max);
    }

    // POST a new product: http://localhost:8080/api/products
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // GET a single product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }
}