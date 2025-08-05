package com.example.ecommerce.entity.user;
import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Long phoneNumber;
    private String password;

//    @ManyToMany
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Roles> role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;



}
