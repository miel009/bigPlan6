package com.example.bigplan;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private List<Place> places = new ArrayList<>();
    private PlaceAdapter adapter;

    // carrusel automático
    private Handler sliderHandler = new Handler();
    private Runnable sliderRunnable;
    private int currentPage = 0;
    private ViewPager2 viewPager;
    private List<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        // para los lugares
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlaceAdapter(this, places);
        recyclerView.setAdapter(adapter);

        populatePlaces();

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterPlaces(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterPlaces(newText);
                return false;
            }
        });

        // Config del  carrusel
        viewPager = findViewById(R.id.viewPager);

        imageList = new ArrayList<>();
        imageList.add(R.drawable.foto1);
        imageList.add(R.drawable.starbucks);
        imageList.add(R.drawable.panerarosa);

        CarruselAdapter carruselAdapter = new CarruselAdapter(imageList);
        viewPager.setAdapter(carruselAdapter);


        startAutoScroll(imageList.size());

        // reinicia
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
    }


    private void startAutoScroll(int totalPages) {
        sliderRunnable = new Runnable() {
            @Override
            public void run() {
                currentPage++;
                if (currentPage >= totalPages) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage, true);
                sliderHandler.postDelayed(this, 3000);
            }
        };
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }


    private void populatePlaces() {
        places.add(new Place("Cafetería", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEBYTar9UYnkkDcdITlEC1TetjvfOmjoZFKg&amp;s"));
        places.add(new Place("Reserva Costanera Sur", "https://www.lanoticiawebciudad.com.ar/wp-content/uploads/2017/05/Playa-La-Naci%C3%B3n1.jpg"));
        places.add(new Place("Museo de Arte", "https://www.mibsas.com/wp-content/uploads/2017/05/malba-1-768x432.jpg"));
        places.add(new Place("Teatro", "https://teatrocolon.org.ar/wp-content/uploads/2023/11/frente-teatro-colon.jpeg"));
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
