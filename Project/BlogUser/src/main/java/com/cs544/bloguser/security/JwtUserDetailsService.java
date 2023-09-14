package com.cs544.bloguser.security;

import com.cs544.bloguser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final com.cs544.bloguser.domain.User customer = userRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("Email not found with email address: " + email);
        }
        UserDetails user = User.withUsername(customer.getEmail())
                .password(customer.getPassword()).build();
        return user;
    }
}
