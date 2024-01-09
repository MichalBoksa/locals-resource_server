package com.example.locals_resource_server.controller;

import com.example.locals_resource_server.model.Guide;
import com.example.locals_resource_server.repository.GuideRepository;
import com.example.locals_resource_server.service.GuideService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/guide")
public class GuideController {

    private GuideService guideService;
    private GuideRepository guideRepository;

    @GetMapping(path = "/cityGuides/{city}")
    public List<Guide> getGuidesInCity(@PathVariable String city) {
        return guideService.getGuidesInCity(city);
    }

    @GetMapping(path="/guideDetails/{id}")
    public Guide getGuideDetails(@PathVariable int id) {
        return guideService.getGuideDetails(id);
    }

    @GetMapping(path="/guideDetailsEmail/{email}")
    public Guide getGuideDetails(@PathVariable String email) {
        return guideService.getGuideDetails(email);
    }

    @PostMapping(path="/addNew")
    public void createGuide(@RequestBody Guide guide) {
         guideService.createNewGuide(guide);
    }

    @PutMapping("/update/{email}")
    public void updateGuide(@PathVariable String email, @RequestBody Guide guide) {
        guideRepository.save(guide);
    }

    @DeleteMapping("/deleteGuide/{email}")
    public void deleteGuide(@PathVariable String email) {
        guideService.deleteGuide(email);
    }



}
