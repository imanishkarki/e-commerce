package com.example.ecommerce.payload;
import com.example.ecommerce.entity.user.Address;
import com.example.ecommerce.enums.Roles;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class SignupDTO {
    private Long phoneNumber;
    private String password;
    private String name;
    private Set<Roles> role;

    //private Roles role;
    private List<Address>  address;

}
