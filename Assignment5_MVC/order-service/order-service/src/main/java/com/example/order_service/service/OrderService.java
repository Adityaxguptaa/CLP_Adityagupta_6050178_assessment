package com.example.order_service.service;

import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import com.example.order_service.client.UserClient;
import com.example.order_service.client.ProductClient;
import com.example.order_service.dto.*;

import java.util.Random;

@Service
public class OrderService {

    private final UserClient userClient;
    private final ProductClient productClient;

    
    public OrderService(UserClient userClient, ProductClient productClient) {
        this.userClient = userClient;
        this.productClient = productClient;
    }

    @CircuitBreaker(name = "moviedetailservice", fallbackMethod = "fallback")
    public OrderResponse createOrder(int userId, int productId, int quantity) {

        User user = userClient.getUser(userId);
        Product product = productClient.getProduct(productId);

        double total = product.getPrice() * quantity;

        return new OrderResponse(
                new Random().nextInt(10000),
                user.getName(),
                product.getName(),
                quantity,
                total
        );
    }

    public OrderResponse fallback(int userId, int productId, int quantity, Exception ex) {
        return new OrderResponse(-1, "Fallback User", "Fallback Product", quantity, 0);
    }
}