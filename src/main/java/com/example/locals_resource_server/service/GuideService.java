package com.example.locals_resource_server.service;

import com.example.locals_resource_server.model.Guide;
import com.example.locals_resource_server.repository.GuideRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GuideService {

    private GuideRepository guideRepository;

    public List<Guide> getGuidesInCity(String city) {
        return guideRepository.findGuideByCity(city);
    }

    public Guide getGuideDetails(int id) {
        var guide = guideRepository.findGuideById(id);
        return guide.map(Guide::new)
                .orElseThrow(() -> new RuntimeException("Runtime exception"));
    }
}
