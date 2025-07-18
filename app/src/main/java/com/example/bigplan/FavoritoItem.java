package com.example.bigplan;

import java.util.Objects;

public class FavoritoItem {
    private String nombre;
    private String descripcion;
    private String imagenUrl;

    public FavoritoItem(String nombre, String descripcion, String imagenUrl) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenUrl=imagenUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    // verif contenido de cada variable junto con el hash valida que no se ingrese un favorito igual
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoritoItem)) return false;   // verificO si el Object o ES realmente es un FavoritoItem
        FavoritoItem that = (FavoritoItem) o;
        return nombre.equals(that.nombre) &&
                descripcion.equals(that.descripcion);
    }
    //  genera un num unico para unir nom y desc
    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion);
    }
}
