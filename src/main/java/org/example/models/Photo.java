package org.example.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Photo {
    private int id;
    private String name;
    private LocalDate date;
    private Location location;
    private Set<String> tags;


    public Photo(int id, String name, LocalDate date,  Location location, Set<String> tags) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.tags = tags;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public LocalDate getDate() {
        return date;
    }

    public Location getLocation() {
        return location;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}

