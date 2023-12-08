package com.example.locals_resource_server.service;

import com.example.locals_resource_server.model.Favorites;
import com.example.locals_resource_server.repository.FavoritesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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

    public void addNewItemFavoritesList(List<Integer> listFavs, String placeId) {
        Favorites fav;
        StringBuilder ids;
        for(Integer item : listFavs) {
           fav = favoritesRepository.findFavoritesById(item);
           ids = new StringBuilder(fav.getPlaceIds());
           if(ids.isEmpty()){
               ids.append(",").append(placeId);
           }
           else {
               ids.append(placeId);
           }
               fav.setPlaceIds(ids.toString());
           favoritesRepository.save(fav);
        }
    }
}
