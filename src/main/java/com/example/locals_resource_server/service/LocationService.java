package com.example.locals_resource_server.service;

import com.example.locals_resource_server.model.Image.DataImage;
import com.example.locals_resource_server.model.Location.DataLocation;
import com.example.locals_resource_server.model.Location.LocationDetails;
import com.example.locals_resource_server.model.Location.LocationSearch;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class LocationService {


    @Value("${tripAdvisor.base.url}")
    private String apiURL;


    @Value("${tripAdvisorAPIKey}")
    private String apiKey;

    private final WebClient webClient;

    public LocationDetails getLocationDetails(String idLocation) {
       LocationDetails locationDetails = webClient.get().uri(apiURL + idLocation+ "/details?language=en&currency=USD&key=" + apiKey)
                                                .header("accept", "application/json")
                                                .retrieve()
                                                .bodyToFlux(LocationDetails.class)
                                                .collect(Collectors.toList())
                                                .block()
                                                .get(0);
      locationDetails.setImagesURLList(getPlaceImages(idLocation));

        return locationDetails;
    }

    public List<LocationDetails> getCityAttractions(String cityName) {
        List<LocationSearch> datalist = webClient.get().uri(apiURL + "search?" + "searchQuery=" + cityName + "&language=en&key=" + apiKey)
                .header("accept", "application/json")
                .retrieve()
                .bodyToMono(DataLocation.class).block().getData();

       datalist.remove(0);
       List<LocationDetails> loclist = datalist.stream().map(place -> getLocationDetails(place.getLocation())).collect(Collectors.toList());
        return loclist;
    }

    public List<String> getPlaceImages(String idLocation) {
        DataImage response = webClient.get().uri(apiURL + idLocation + "/photos?language=en&key=" + apiKey)
                .header("accept","application/json")
                .retrieve()
                .bodyToMono(DataImage.class)
                .block()
                ;
      List<String> urlList = response.getData().stream().map(
              attribute -> attribute.getImages().getMedium().getURL()
      ).collect(Collectors.toList()); ;

      return urlList;
    }

    public List<LocationDetails> getFavoritesLocationDetails(String ids) {
        List<LocationDetails> result = new ArrayList<>();
        List<String> idList = Arrays.asList(ids.split(","));
        for(String id : idList) {
            result.add(getLocationDetails(id));
        }
        return result;
    }
}
