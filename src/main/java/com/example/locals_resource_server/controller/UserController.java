package com.example.locals_resource_server.controller;

import com.example.locals_resource_server.model.User;
import com.example.locals_resource_server.repository.UserRepository;
import com.example.locals_resource_server.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/RSUser")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @GetMapping("/getUser/{email}")
    public User getUser(@PathVariable String email) {
       return userService.getUser(email);
    }

    @GetMapping("/getUserId/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/updateImage/{email}")
    public void updateImage(@PathVariable String email, @RequestBody String image) {
        User user = userService.getUser(email);
        user.setImageUri(image);
        userRepository.save(user);
    }

    @PutMapping("/updateEmail/{email}")
    public void updateEmail(@PathVariable String email, @RequestBody String newEmail) {
        User user = userService.getUser(email);
        newEmail = newEmail.substring(1,newEmail.length()-1);
        user.setEmail(newEmail);
        userRepository.save(user);
    }

    @PutMapping("/updatePhone/{email}")
    public void updatePhone(@PathVariable String email, @RequestBody String phone) {
        User user = userService.getUser(email);
        phone = email.substring(1,phone.length()-1);
        user.setPhoneNumber(phone);
        userRepository.save(user);
    }
}
