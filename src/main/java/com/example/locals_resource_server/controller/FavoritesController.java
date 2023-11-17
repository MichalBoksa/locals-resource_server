package com.example.locals_resource_server.controller;


import com.example.locals_resource_server.model.Favorites;
import com.example.locals_resource_server.service.FavoritesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/favorites")
public class FavoritesController {

    private FavoritesService favoritesService;

    @GetMapping(path = "/userFavorites/{id}")
    public ArrayList<Favorites> getUserFavorites(@PathVariable int id) {
        return favoritesService.getUserFavorites(id);
    }

    @PostMapping(path = "/addNewList")
    public void addNewFavoritesList(@RequestBody Favorites favorites) {
        favoritesService.addNewFavoritesList(favorites);
    }

}
