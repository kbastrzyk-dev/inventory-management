package com.allegro.intern.inventorymanagement.config;

import com.allegro.intern.inventorymanagement.model.Product;
import com.allegro.intern.inventorymanagement.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) { // Only seed if the DB is empty
                System.out.println("Seeding initial products to database...");

                Product p1 = new Product(null, "Smartphone Galaxy", "Newest model", "SKU-GAL-001", new BigDecimal("2999.99"), 50, "Electronics");
                Product p2 = new Product(null, "Wireless Headphones", "Noise cancelling", "SKU-HEA-99", new BigDecimal("549.00"), 120, "Electronics");
                Product p3 = new Product(null, "Coffee Machine", "Makes great espresso", "SKU-COF-12", new BigDecimal("1200.50"), 15, "Home");

                repository.saveAll(List.of(p1, p2, p3));
                System.out.println("Seeding complete!");
            }
        };
    }
}