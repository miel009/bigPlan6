package com.example.bigplan;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class DetalleActivity extends AppCompatActivity {

    private WebView webViewMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_activity);

        // Obtener datos del intent
        String nombre = getIntent().getStringExtra("nombre");
        String descripcion = getIntent().getStringExtra("descripcion");

        // Referenciar vistas
        TextView nombreTextView = findViewById(R.id.tvNombreDetalle);
        TextView descripcionTextView = findViewById(R.id.tvDescripcionDetalle);
        Button agregarFavoritosButton = findViewById(R.id.btnAgregarFavoritos);
        //mapa
        webViewMap = findViewById(R.id.webViewMap);

        // Mostrar datos en las vistas
        nombreTextView.setText(nombre);
        descripcionTextView.setText(descripcion);

        // Configurar botón de agregar a favoritos
        agregarFavoritosButton.setOnClickListener(view -> {
            SharedFavoritos.addFavorito(new FavoritoItem(nombre, descripcion));
            Toast.makeText(this, "Agregado a Favoritos", Toast.LENGTH_SHORT).show();
            finish();
        });

        // Cargar mapa
        loadMap(nombre);

    }
        private void loadMap(String query) {
            String url = "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(query);
            webViewMap.setWebViewClient(new WebViewClient());
            WebSettings webSettings = webViewMap.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webViewMap.loadUrl(url);
        }
}