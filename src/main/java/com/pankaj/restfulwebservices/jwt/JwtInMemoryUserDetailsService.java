package com.pankaj.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pankaj.restfulwebservices.model.User;
import com.pankaj.restfulwebservices.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> findFirst = Optional.ofNullable(userDetailsServiceImpl.loadUserByUsername(username));

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return findFirst.get();
    }

}