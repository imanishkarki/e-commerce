package com.example.ecommerce.entity.order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Cart {
    private Long id;
    private Long userId;
    private Long productId;
    private int quantity;
    private double price;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
