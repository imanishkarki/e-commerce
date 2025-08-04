package com.example.ecommerce.service.ServiceImpl;
import com.example.ecommerce.entity.user.Address;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.payload.LoginDTO;
import com.example.ecommerce.payload.SignupDTO;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManger;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManger, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManger = authenticationManger;
        this.jwtService = jwtService;
    }

    @Override
    public String signUp(SignupDTO signupDTO) {
        if (userRepository.findByPhoneNumber(signupDTO.getPhoneNumber()).isPresent()){
            return "user already exists!";
        }
        User user =  User.builder()
                .phoneNumber(signupDTO.getPhoneNumber())
                .name(signupDTO.getName())
                .password(passwordEncoder.encode(signupDTO.getPassword()))
                .role(signupDTO.getRole())
             //   .address(signupDTO.getAddress())
                .build();

        // Link user to each address
        if (signupDTO.getAddress() != null) {
            for (Address address : signupDTO.getAddress()) {
                address.setUser(user); //
            }
            user.setAddress(signupDTO.getAddress()); // If User has `List<Address>` in it
        }

        userRepository.save(user);
        return "User created successfully";
    }

    @Override
    public String verify(LoginDTO loginDTO) {

        Authentication authenticate =
                authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getPhoneNumber(), loginDTO.getPassword()));
        if ( authenticate.isAuthenticated()){
             jwtService.generateToken(loginDTO.getPhoneNumber());
            return "login successful!";
        }else {
            return "login failed!";
        }

    }
}
