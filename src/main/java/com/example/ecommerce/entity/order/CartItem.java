package com.example.ecommerce.entity.order;

import com.example.ecommerce.entity.product.Product;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

public class CartItem {
    private Long  productId;
    @ManyToOne
    private Cart cart;
    @ManyToMany


}
