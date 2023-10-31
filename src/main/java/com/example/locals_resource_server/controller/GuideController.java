package com.example.locals_resource_server.controller;

import com.example.locals_resource_server.model.Guide;
import com.example.locals_resource_server.service.GuideService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/guide")
public class GuideController {

    private GuideService guideService;

    @GetMapping(path = "/cityGuides/{city}")
    public List<Guide> getGuidesInCity (@PathVariable String city) {
        return guideService.getGuidesInCity(city);
    }
}
