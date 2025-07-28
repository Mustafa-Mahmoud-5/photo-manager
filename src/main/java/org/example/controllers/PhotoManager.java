package org.example.controllers;

import org.example.models.Photo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhotoManager {
    private Map photos;

    public  PhotoManager() {
        this.photos = new HashMap<>();
    }

    public void uploadPhoto (Photo photo) {

    }

    public void removePhoto(int id) {

    }

    public List<Photo> searchByTag(String tag) {
        return new ArrayList<>();
    }

    public List<Photo> searchByDate(LocalDate date) {
        return new ArrayList<>();
    }

    public List<Photo> searchByLocation(String locationName) {
        return new ArrayList<>();
    }
}
