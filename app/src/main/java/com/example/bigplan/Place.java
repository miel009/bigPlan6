package com.example.bigplan;
public class Place {
    private final String title;
    private final String imageUrl;

    public Place(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
