package com.example.ecommerce.entity.product;

import com.example.ecommerce.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SubCategory extends BaseEntity {

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn( name = "category_id", nullable = false)
    private Category category;

    @OneToMany
    private List<Product> products;
}
