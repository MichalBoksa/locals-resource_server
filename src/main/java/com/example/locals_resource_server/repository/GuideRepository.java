package com.example.locals_resource_server.repository;


import com.example.locals_resource_server.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GuideRepository extends JpaRepository<Guide,Integer> {
    List<Guide> findGuideByCity(String city);

}
