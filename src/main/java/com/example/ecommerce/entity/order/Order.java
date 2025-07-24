package com.example.ecommerce.entity.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    private String status;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;
    // private Address ShippingAddress;
    // private String paymentMethod;
    //private String shipmentMethod;
    private double totalAmount;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}