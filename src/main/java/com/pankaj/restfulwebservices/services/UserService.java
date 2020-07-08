package com.pankaj.restfulwebservices.services;

import com.pankaj.restfulwebservices.model.User;
import com.pankaj.restfulwebservices.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void saveUsers(User... users) {
        for(User user : users) {
            log.info("Saving User: " + user.getUsername());
            userRepository.save(user);
        }
    }
}
