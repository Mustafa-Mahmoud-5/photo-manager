package org.example.models;

public class City {
    private double radius;
    private String name;
    Location location;

    public City(Location location, double radius, String name) {
        this.radius = radius;
        this.name = name;
        this.location = location;
    }


    public Location getLocation() {
        return location;
    }

    public double getRadius() {
        return radius;
    }


    public String getName() {
        return name;
    }


    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
