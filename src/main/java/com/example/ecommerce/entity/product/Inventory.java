package com.example.ecommerce.entity.product;

import com.example.ecommerce.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Inventory extends BaseEntity {
    private int stockQuantity;
    private LocalDateTime lastRestocked;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


}
