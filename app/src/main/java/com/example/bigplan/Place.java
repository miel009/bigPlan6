package com.example.bigplan;
public class Place {
    private final String title;
    private final String imagenUrl;
    private String descripcion;

    public Place(String title, String imageUrl, String descripcion) {
        this.title = title;
        this.imagenUrl = imageUrl;
        this.descripcion = descripcion;
    }

    public String getTitle() {
        return title;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
