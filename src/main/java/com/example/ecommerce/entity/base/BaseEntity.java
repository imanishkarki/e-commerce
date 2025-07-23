package com.example.ecommerce.entity.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Data
@SuperBuilder
public class BaseEntity {
    @Id
    @GeneratedValue(strategy  = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
}
