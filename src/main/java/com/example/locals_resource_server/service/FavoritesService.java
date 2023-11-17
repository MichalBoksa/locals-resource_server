package com.example.locals_resource_server.service;

import com.example.locals_resource_server.model.Favorites;
import com.example.locals_resource_server.repository.FavoritesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class FavoritesService {

    private FavoritesRepository favoritesRepository;

    public ArrayList<Favorites> getUserFavorites(int userId) {
       return favoritesRepository.findFavoritesByUserId(userId);
    }

    public void addNewFavoritesList(Favorites favorites) {

            favoritesRepository.save(favorites);
    }
}
