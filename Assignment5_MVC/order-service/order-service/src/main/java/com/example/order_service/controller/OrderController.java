package com.example.order_service.controller;

import org.springframework.web.bind.annotation.*;
import com.example.order_service.service.OrderService;
import com.example.order_service.dto.OrderResponse;
import com.example.order_service.dto.OrderRequest;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest req) {
        return service.createOrder(
                req.getUserId(),
                req.getProductId(),
                req.getQuantity()
        );
    }
}