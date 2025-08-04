package com.example.ecommerce.payload;
import com.example.ecommerce.entity.user.Address;
import com.example.ecommerce.enums.Roles;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class SignupDTO {
    private Long phoneNumber;
    private String password;
    private String name;
    private Roles role;
    private List<Address>  address;

}
