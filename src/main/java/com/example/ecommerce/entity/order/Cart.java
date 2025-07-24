package com.example.ecommerce.entity.order;

import com.example.ecommerce.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int quantity;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToOne
    private User user;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private Order order;

    private BigDecimal totalAmount;
}