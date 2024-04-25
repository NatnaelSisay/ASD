package com.example.ecommerce.security;

import com.example.ecommerce.dtos.user.UserDetail;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailService implements UserDetailsService {
    UserRepository userRepository;

    public SecurityUserDetailService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(email).orElse(null);
        if (user == null) return null;

        UserDetail userDetail = new UserDetail(
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName()
        );

        return userDetail;
    }
}
