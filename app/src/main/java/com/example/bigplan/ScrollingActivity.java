package com.example.bigplan;

import android.annotation.SuppressLint;
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


    @SuppressLint("NotifyDataSetChanged")
    private void populatePlaces() {
        places.add(new Place("Café Villazón", "https://lh3.googleusercontent.com/p/AF1QipNIuAuqiibicc9FGMyFwUPHGu55CXNOpJhhrFfw=w408-h543-k-no"));
        places.add(new Place("Reserva Costanera Sur", "https://www.lanoticiawebciudad.com.ar/wp-content/uploads/2017/05/Playa-La-Naci%C3%B3n1.jpg"));
        places.add(new Place("Museo Nacional de Bellas Artes", "https://lh3.googleusercontent.com/gps-cs-s/AC9h4nrUhxnrBgpcreHVy18Ff6Q5O77Zwc_TV73mKB--CGQZujY2_OMnHBxslLlxsP6UwCsj0pKQhwvww9-Ynz_G164oUXRob6PJafAPQhhBzDHKrLS9p1CoAe-KmtrstxvnApbeTYo=w408-h306-k-no"));
        places.add(new Place("Teatro Colón", "https://lh3.googleusercontent.com/gps-cs-s/AC9h4np7sQYdiF_hXHJMx55pYkwKX6uvMVEUjOlMytiafJOvHz8c9l5fnlzzaHQAGBti5airaz_Tvjpz5-z5lX0KE4pPIBM5MZvbyg_KPq_fAj-Ojd66-28DOFJKEkdGAGXYCS4-Pmg5JA=w408-h271-k-no"));
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
