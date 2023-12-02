package com.example.locals_resource_server.service;

import com.example.locals_resource_server.model.User;
import com.example.locals_resource_server.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User getUser(String email) {
        var user = userRepository.findUserByEmail(email);
        return user.map(User::new)
                .orElseThrow(() -> new RuntimeException("Runtime exception"));
    }
}
