package com.example.product_service.service;

import org.springframework.stereotype.Service;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.model.Product;

@Service
public class ProductService {

    private final ProductRepository repo;


    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product getProduct(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product saveProduct(Product product) {
        return repo.save(product);
    }
}