package com.example.ecommerce.service.ServiceImpl;
import com.example.ecommerce.entity.user.Address;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.payload.LoginDTO;
import com.example.ecommerce.payload.SignupDTO;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String signUp(SignupDTO signupDTO) {
        User user = new User();
        user.setName(signupDTO.getName());
        user.setPassword(signupDTO.getPassword());
        user.setPhoneNumber(signupDTO.getPhoneNumber());
        user.setRole(signupDTO.getRole());

        // Set up address relationships
        if (signupDTO.getAddress() != null) {
            for (Address address : signupDTO.getAddress()) {
                address.setUser(user); // set the reverse relation
            }
            user.setAddress(signupDTO.getAddress());
        }

        userRepository.save(user);
        return "User signup successful!";
    }

    @Override
    public String verify(LoginDTO loginDTO) {
        return "login successful!";
    }
}
