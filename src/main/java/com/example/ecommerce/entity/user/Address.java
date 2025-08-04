package com.example.ecommerce.entity.user;

import com.example.ecommerce.entity.order.Shipment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String Country;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Shipment shipment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}