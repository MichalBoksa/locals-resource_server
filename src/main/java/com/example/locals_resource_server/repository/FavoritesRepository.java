package com.example.locals_resource_server.repository;

import com.example.locals_resource_server.model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface FavoritesRepository extends JpaRepository<Favorites,Integer> {
    ArrayList<Favorites> findFavoritesByUserId(int userId);
    Favorites findFavoritesById(int id);
}
