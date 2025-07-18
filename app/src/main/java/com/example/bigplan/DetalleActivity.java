package com.example.bigplan;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class DetalleActivity extends BaseActivity {

    private WebView webViewMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_activity);

        // recupera datos del intent
        String nombre = getIntent().getStringExtra("nombre");
        String descripcion = getIntent().getStringExtra("descripcion");
        String imagenUrl = getIntent().getStringExtra("imagenUrl");

        TextView nombreTextView = findViewById(R.id.tvNombreDetalle);
        TextView descripcionTextView = findViewById(R.id.tvDescripcionDetalle);
        Button agregarFavoritosButton = findViewById(R.id.btnAgregarFavoritos);

        setupFooterNavigation();

        //mapa
        webViewMap = findViewById(R.id.webViewMap);

        // Mostrar datos en las vistas
        nombreTextView.setText(nombre);
        descripcionTextView.setText(descripcion);

        // Configurar botón de agregar a favoritos
        agregarFavoritosButton.setOnClickListener(view -> {
            SharedFavoritos.addFavorito(new FavoritoItem(nombre, descripcion, imagenUrl));
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

    @Override
    protected void onSearchClicked() {
        SearchView searchView = findViewById(R.id.searchView);
        if (searchView != null) {
            searchView.setIconified(false);
            searchView.requestFocus();       // para que el usuario pueda escribir
        }
    }
}