package com.example.order_service.dto;

public class OrderResponse {

    private int orderId;
    private String userName;
    private String productName;
    private int quantity;
    private double totalPrice;

    public OrderResponse(int orderId, String userName, String productName, int quantity, double totalPrice) {
        this.orderId = orderId;
        this.userName = userName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() { return orderId; }
    public String getUserName() { return userName; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return totalPrice; }
}