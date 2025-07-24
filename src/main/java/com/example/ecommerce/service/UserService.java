package com.example.ecommerce.service;

import com.example.ecommerce.payload.LoginDTO;
import com.example.ecommerce.payload.SignupDTO;

public interface UserService {
    String signUp(SignupDTO signupDTO);

    String verify(LoginDTO loginDTO);
}
