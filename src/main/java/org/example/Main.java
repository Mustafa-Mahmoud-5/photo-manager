package org.example;

import org.example.controllers.Cities;
import org.example.controllers.PhotoManager;
import org.example.models.City;
import org.example.models.Location;
import org.example.models.Photo;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // prepare locations
        Location cairoUniversityLoc = new Location(40, 35);
        Location gemLoc = new Location(50, 60);
        Location pyramidsLoc = new Location(52, 65);
        Location elNorMosqueLoc = new Location(19, 19);


        Location cairoCityLocation = new Location(15, 15);
        Location gizaCityLocation = new Location(25, 25);


        // make some cities first
        Cities cities = new Cities();
        cities.addCity(new City(cairoCityLocation, 5, "cairo"));
        cities.addCity(new City(gizaCityLocation, 5, "giza"));

        PhotoManager manager = new PhotoManager(cities);

        // Upload some Egyptian photos
        manager.uploadPhoto(new Photo(1, "pyramids.jpg", LocalDate.of(2023, 3, 10),
                pyramidsLoc, Set.of("pyramids", "history", "egypt", "tourism")));

        manager.uploadPhoto(new Photo(2, "nile.jpg", LocalDate.of(2023, 4, 22),
                cairoUniversityLoc, Set.of("nile", "river", "sunset", "egypt")));

        manager.uploadPhoto(new Photo(3, "mosque.jpg", LocalDate.of(2023, 4, 22),
                elNorMosqueLoc, Set.of("mosque", "islamic", "architecture", "egypt")));

        manager.uploadPhoto(new Photo(4, "museum.jpg", LocalDate.of(2023, 5, 15),
                gemLoc, Set.of("museum", "antiquities", "egypt", "pharaohs")));

        // Search by single tag
        System.out.println("Photos with tag 'egypt':");
        manager.searchByTag("egypt").forEach(System.out::println);

        // Search by date
        System.out.println("Photos taken on 2023-04-22:");
        manager.searchByDate(LocalDate.of(2023, 4, 22)).forEach(System.out::println);

        // Search by location
        // Note: The goal here is that i give a city name as a string, the function goes and get the corresponding city
        // and then get all photos that their locations are in this city
//                System.out.println("Photos taken in Cairo:");
//                manager.searchByLocation("cairo").forEach(System.out::println);

        // Search by multiple tags
        System.out.println("Photos with tags [egypt, museum]:");
        manager.searchByMultipleTags(Set.of("egypt", "museum")).forEach(System.out::println);
    }
}