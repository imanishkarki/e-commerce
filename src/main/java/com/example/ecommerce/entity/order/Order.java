package com.example.ecommerce.entity.order;

import com.example.ecommerce.entity.user.Address;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private String orderNumber;
    private String status;
    private String customerName;
    private Address ShippingAddress;
    private String paymentMethod;
    private String shipmentMethod;
    private double totalAmount;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
