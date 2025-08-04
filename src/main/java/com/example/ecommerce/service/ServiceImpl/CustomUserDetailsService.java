package com.example.ecommerce.service.ServiceImpl;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = userRepository.findByPhoneNumber(Long.valueOf(phoneNumber))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + phoneNumber));

        return new CustomUserDetails(user);
    }
}
