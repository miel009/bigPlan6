package com.example.bigplan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FavoritesActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private FavoritesAdapter favoritesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        setupFooterNavigation();
        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.favoritesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener lista de favoritos desde SharedFavoritos
        List<FavoritoItem> favoriteItems = SharedFavoritos.getFavoritos();

        // Configurar el adaptador para trabajar con FavoritoItem
        favoritesAdapter = new FavoritesAdapter(favoriteItems);
        recyclerView.setAdapter(favoritesAdapter);
    }

    @Override
    protected void onSearchClicked() {
        SearchView searchView = findViewById(R.id.searchView);
        if (searchView != null) {
            searchView.setIconified(false);
            searchView.requestFocus();       // para que el usuario pueda escribir
        }
    }
}
