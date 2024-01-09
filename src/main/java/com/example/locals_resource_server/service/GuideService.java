package com.example.locals_resource_server.service;

import com.example.locals_resource_server.model.Booking;
import com.example.locals_resource_server.model.Guide;
import com.example.locals_resource_server.repository.GuideRepository;
import com.example.locals_resource_server.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GuideService {

    private GuideRepository guideRepository;
    private UserRepository userRepository;

    public List<Guide> getGuidesInCity(String city) {
        return guideRepository.findGuideByCity(city);
    }

    public Guide getGuideDetails(int id) {
        var guide = guideRepository.findGuideById(id);
        return guide.map(Guide::new)
                .orElseThrow(() -> new RuntimeException("Runtime exception"));
    }

    public void createNewGuide(Guide guide) {
       //TODO add if exist check
        guideRepository.save(guide);
    }

    public Guide getGuideDetails(String email) {
        var guide = guideRepository.findGuideByEmail(email);
        return guide.map(Guide::new)
                .orElseThrow(() -> new RuntimeException("Runtime exception"));
    }

    public void deleteGuide(String email) {
        guideRepository.delete(getGuideDetails(email));
    }

 }
