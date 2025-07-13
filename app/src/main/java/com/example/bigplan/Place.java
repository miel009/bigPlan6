package com.example.bigplan;
public class Place {
    private final String title;
    private final String imageUrl;
    private String descripcion;

    public Place(String title, String imageUrl, String descripcion ) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.descripcion = descripcion;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
