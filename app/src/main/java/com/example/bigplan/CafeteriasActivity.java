package com.example.bigplan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CafeteriasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CafeteriaAdapter cafeteriaAdapter;
    private List<Cafeteria> cafeteriaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeterias);

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar la lista de cafeterías
        cafeteriaList = new ArrayList<>();
        populateCafeteriaList();

        // Configurar el adaptador
        cafeteriaAdapter = new CafeteriaAdapter(cafeteriaList, cafeteria -> {
            Intent intent = new Intent(CafeteriasActivity.this, DetalleActivity.class);
            intent.putExtra("nombre", cafeteria.getNombre());
            intent.putExtra("direccion", cafeteria.getAddress());
            startActivity(intent);
        });
        recyclerView.setAdapter(cafeteriaAdapter);

        // Configurar botón de favoritos
        Button btnVerFavoritos = findViewById(R.id.btnVerFavoritos);
        btnVerFavoritos.setOnClickListener(v -> {
            Intent intent = new Intent(this, FavoritesActivity.class);
            startActivity(intent);
        });
    }

    // Método para rellenar la lista de cafeterías
    private void populateCafeteriaList() {
        cafeteriaList.add(new Cafeteria("Cafetería Central", "Av. Siempre Viva 123"));
        cafeteriaList.add(new Cafeteria("Café del Parque", "Calle Ficticia 456"));
    }
}
