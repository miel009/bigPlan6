package com.example.bigplan;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {


    protected void setupFooterNavigation() {
        LinearLayout btnFav = findViewById(R.id.btn_fav);
        LinearLayout btnBuscar = findViewById(R.id.btn_buscar);
        LinearLayout btnNotif = findViewById(R.id.btn_notif);

        if (btnFav != null) {
            btnFav.setOnClickListener(v -> {
                Intent intent = new Intent(this, FavoritesActivity.class);
                startActivity(intent);
            });
        }
        if (btnBuscar != null) {
            btnBuscar.setOnClickListener(v -> onSearchClicked());
        }


        if (btnNotif != null) {
            btnNotif.setOnClickListener(v -> {
                // si quisiera ver el alert
                // Toast.makeText(this, "Notificaciones clickeado", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(BaseActivity.this)
                        .setTitle("Notificaciones")
                        .setMessage("No tienes nuevas notificaciones.")
                        .setPositiveButton("OK", null)
                        .show();
            });
    }
    }
        protected void onSearchClicked() {

        }
}
