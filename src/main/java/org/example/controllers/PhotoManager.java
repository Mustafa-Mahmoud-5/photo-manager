package org.example.controllers;

import org.example.models.Photo;

import java.time.LocalDate;
import java.util.*;

// note: this class now manages both photos and indexes, but a class should be specific
// and has does only one thing
// TODO: make a separate class for indexes and make them added dynamically based on a string/attribute

public class PhotoManager {
    private Map<Integer, Photo> photos;
    private Cities cities;

    private Map<String, Set<Photo>> tagIndex;
    private TreeMap<LocalDate, Set<Photo>> dateIndex;

    public  PhotoManager(Cities cities) {
        photos = new HashMap<>();

        // each attribute we will use alot for searching will have an index-like DS
        // iam trying to mimic how dbs work(in a simple way ofc)
        // hashmap key access is o(1) best case, then we retrieve the list of items..

        tagIndex = new HashMap<>();

        // i need it sorted by key(date) so we can enhance range queries for date range filters
        dateIndex = new TreeMap<>();

        this.cities = cities;
    }

    public void uploadPhoto(Photo photo) {
        int id = photo.getId();
        photos.put(id, photo);

        // index the city in all tags
        Set<String> tags = photo.getTags();
        for (String tag : tags) {
            if (!tagIndex.containsKey(tag) ) {
                tagIndex.put(tag,  new HashSet<>());
            }

            tagIndex.get(tag).add(photo);
        }


        // Index by date
        LocalDate date = photo.getDate();
        if (!dateIndex.containsKey(date)) {
            dateIndex.put(date, new HashSet<>());
        }
        dateIndex.get(date).add(photo);
    }


    public void removePhoto(int id) {
        Photo photo = photos.remove(id);
        if (photo == null) {
            return;
        }

        // Remove from tag index
        Set<String> tags = photo.getTags();
        for (String tag : tags) {
            if (tagIndex.containsKey(tag)) {
                Set<Photo> photoSet = tagIndex.get(tag);
                photoSet.remove(photo);
                if (photoSet.isEmpty()) {
                    tagIndex.remove(tag);
                }
            }
        }

        // remove from  d ate index
        LocalDate date = photo.getDate();
        if (dateIndex.containsKey(date)) {
            Set<Photo> p = dateIndex.get(date);
            p.remove(photo);
            // it means that the map value holds an empty set
            if (p.isEmpty()) {
                dateIndex.remove(date);
            }
        }
    }

    public List<Photo> searchByTag(String tag) {
        if (!tagIndex.containsKey(tag)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(tagIndex.get(tag));
    }

    public Set<Photo> searchByDate(LocalDate date) {
        if (!dateIndex.containsKey(date)) {
            return new HashSet<>();
        }
        return dateIndex.get(date);
    }

    public Set<Photo> searchByMultipleTags(Set<String> tags) {
        Set<Photo> result = new HashSet<>();

        if(tags.isEmpty()) {
            return result;
        }

        Iterator<String> firstTag = tags.iterator();
        result.addAll((tagIndex.get(firstTag.next()))); // add all photos with first tag

        // o(NM)
        for (String tag: tags) { // n
            if (tagIndex.containsKey(tag)) { // 1
                result.retainAll(tagIndex.get(tag)); // retailAll will do Intersection // m
            }
        }

        // if we haven't depend on index and made a full scan over photos? will also be o(NM)
        return result;
    }
}
