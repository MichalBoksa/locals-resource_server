package com.example.locals_resource_server.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuideController {

    @GetMapping(path = "/test")
    public String Hello(Authentication a) {
        return "HELLO from rs";
    }
}
