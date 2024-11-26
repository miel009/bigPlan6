package com.example.bigplan;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private List<Place> places = new ArrayList<>();
    private PlaceAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        // Configuración del RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PlaceAdapter(this, places);
        recyclerView.setAdapter(adapter);

        // Agregar datos
        populatePlaces();

        // Configuración del SearchView
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Filtrar resultados
                filterPlaces(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterPlaces(newText);
                return false;
            }
        });
    }

    private void populatePlaces() {
        places.add(new Place("Cafetería", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEBYTar9UYnkkDcdITlEC1TetjvfOmjoZFKg&amp;s"));
        places.add(new Place("Reserva Costanera Sur", "https://www.lanoticiawebciudad.com.ar/wp-content/uploads/2017/05/Playa-La-Naci%C3%B3n1.jpg"));
        places.add(new Place("Museo de Arte", "https://www.mibsas.com/wp-content/uploads/2017/05/malba-1-768x432.jpg"));
        places.add(new Place("Teatro ", "https://teatrocolon.org.ar/wp-content/uploads/2023/11/frente-teatro-colon.jpeg"));
        adapter.notifyDataSetChanged();
    }

    private void filterPlaces(String query) {
        List<Place> filtered = new ArrayList<>();
        for (Place place : places) {
            if (place.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filtered.add(place);
            }
        }
        adapter = new PlaceAdapter(this, filtered);
        ((RecyclerView) findViewById(R.id.recyclerView)).setAdapter(adapter);
    }




}


