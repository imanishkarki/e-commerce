package com.example.ecommerce.entity.order;
import com.example.ecommerce.entity.user.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private Order order;

    @OneToOne
    private Address address;
    private LocalDateTime shippedAt;
    private LocalDateTime deliveredAt;
}
