package com.example.bigplan;

import java.util.ArrayList;
import java.util.List;

public class SharedFavoritos {
    private static final List<FavoritoItem> favoritos = new ArrayList<>();

    public static void addFavorito(FavoritoItem item) {
        if (!favoritos.contains(item)) {
            favoritos.add(item);
        }
    }

    public static List<FavoritoItem> getFavoritos() {
        return favoritos;
    }
}
