package com.example.ecommerce.entity.product;
import com.example.ecommerce.entity.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Brand extends BaseEntity {

    private String name;
    private String description;

    @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL)
    private List<Product> products;
}
