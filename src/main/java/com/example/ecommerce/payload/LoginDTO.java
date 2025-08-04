package com.example.ecommerce.payload;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LoginDTO {

    private Long phoneNumber;
    private String password;

}
