package com.example.bigplan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity1 extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        Button btnCreateAccount = findViewById(R.id.btnCreateAccount);
        Button btnLogin = findViewById(R.id.btnLogin);


        // Registrar nuevo usuario
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (!validateInputs(email, password)) return;

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity1.this, task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity1.this, "Cuenta creada con éxito", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                goToScrollingActivity();
                            } else {
                                String error = task.getException() != null ? task.getException().getMessage() : "Error desconocido";
                                Log.e("CREATE_ACCOUNT_ERROR", "Error al crear cuenta: " + error);
                                Toast.makeText(MainActivity1.this, "Error: " + error, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        // Iniciar sesión con usuario existente
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (!validateInputs(email, password)) return;

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity1.this, task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity1.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                goToScrollingActivity();
                            } else {
                                String error = task.getException() != null ? task.getException().getMessage() : "Error desconocido";
                                Log.e("LOGIN_ERROR", "Error en login: " + error);
                                Toast.makeText(MainActivity1.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


    }

    private boolean validateInputs(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Por favor, ingresa tu correo", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Por favor, ingresa un correo válido", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Por favor, ingresa tu contraseña", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void goToScrollingActivity() {
        Intent intent = new Intent(MainActivity1.this, ScrollingActivity.class);
        startActivity(intent);
        finish();
    }
}
