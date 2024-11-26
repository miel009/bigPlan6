package com.example.bigplan;

import android.os.Bundle;
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
        recyclerView = findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Inicializar la lista de cafeterías
        cafeteriaList = new ArrayList<>();
        cafeteriaList.add(new Cafeteria("Cafetería Central", "Av. Siempre Viva 123"));
        cafeteriaList.add(new Cafeteria("Café del Parque", "Calle Ficticia 456"));

        // Configurar el adaptador
        cafeteriaAdapter = new CafeteriaAdapter(cafeteriaList);
        recyclerView.setAdapter(cafeteriaAdapter);

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cafeterias);

            // Configurar RecyclerView y lista de cafeterías
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            cafeteriaList = new ArrayList<>();
            cafeteriaList.add(new Cafeteria("Cafetería Central", "Av. Siempre Viva 123"));
            cafeteriaList.add(new Cafeteria("Café del Parque", "Calle Ficticia 456"));

            cafeteriaAdapter = new CafeteriaAdapter(cafeteriaList, cafeteria -> {
                Intent intent = new Intent(CafeteriasActivity.this, CafeteriaDetailActivity.class);
                intent.putExtra("nombre", cafeteria.getNombre());
                intent.putExtra("direccion", cafeteria.getDireccion());
                startActivity(intent);
            });
            recyclerView.setAdapter(cafeteriaAdapter);

            // Botón de favoritos
            Button btnVerFavoritos = findViewById(R.id.btnVerFavoritos);
            btnVerFavoritos.setOnClickListener(v -> {
                Intent intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
            });
        }
    }
}

