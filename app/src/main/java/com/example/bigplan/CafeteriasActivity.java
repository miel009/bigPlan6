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
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar la lista de cafeterías
        cafeteriaList = new ArrayList<>();
        cafeteriaList.add(new Cafeteria("Cafetería Central", "Av. Siempre Viva 123"));
        cafeteriaList.add(new Cafeteria("Café del Parque", "Calle Ficticia 456"));

        // Configurar el adaptador
        cafeteriaAdapter = new CafeteriaAdapter(cafeteriaList);
        recyclerView.setAdapter(cafeteriaAdapter);
    }
}

