package com.example.bigplan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling); // Cambiado para cargar el diseño correcto

        // Configuración del SearchView
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Redirigir si el usuario busca "Cafeterías"
                if (query.equalsIgnoreCase("Cafeterias")) {
                    Intent intent = new Intent(ScrollingActivity.this, CafeteriasActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ScrollingActivity.this, "No hay resultados para: " + query, Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Aquí puedes manejar la lógica mientras el usuario escribe, si es necesario.
                return false;
            }
        });
    }
}
