package com.example.bigplan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bigplan.databinding.ActivityScrollingBinding;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Infla el diseño con el Binding
        ActivityScrollingBinding binding = ActivityScrollingBinding.inflate(getLayoutInflater());

        // Establece el layout de la actividad, asegurándote de que esté configurado para desplazar
        setContentView(binding.getRoot());
    }
}
