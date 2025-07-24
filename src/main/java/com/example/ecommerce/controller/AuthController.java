package com.example.ecommerce.controller;
import com.example.ecommerce.payload.LoginDTO;
import com.example.ecommerce.payload.SignupDTO;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignupDTO signupDTO){

        userService.signUp(signupDTO);
        return "Signed up successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO){
        userService.verify(loginDTO);
        return "hdsfhsdkjhfjksdhfiuohsdkf15456dg655sd44f65sd4fsd55f4s3df4";
    }
}
