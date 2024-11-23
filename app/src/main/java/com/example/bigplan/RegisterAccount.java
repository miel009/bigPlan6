package com.example.bigplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_account); // Asegúrate de usar el layout correcto

        // Configuración del botón "Registrar"
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterAccount.this, MainActivity1.class);
                startActivity(intent);
                finish(); // Finaliza la actividad actual
            }
        });

        // Configuración del botón "Volver"
        Button btnBackToLogin = findViewById(R.id.btnBackToLogin);
        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navega de regreso a la pantalla de inicio de sesión
                Intent intent = new Intent(RegisterAccount.this, MainActivity1.class);
                startActivity(intent);
                finish(); // Finaliza la actividad actual
            }
        });
    }
}