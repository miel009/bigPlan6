package com.example.bigplan;

public class Cafeteria {
    private String name;
    private String address;

    public Cafeteria(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters y setters
    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
