package org.example.controllers;

import org.example.models.City;

import java.util.HashMap;
import java.util.Map;

public class Cities {

    Map<String, City> cities;

    public Cities() {
        cities = new HashMap<>();
    }

    public void addCity(City city) {
        cities.put(city.getName(), city);
    }
}
