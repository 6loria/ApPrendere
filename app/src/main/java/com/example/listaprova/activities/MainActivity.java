package com.example.listaprova.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listaprova.models.DefaultResponses;
import com.example.listaprova.R;
import com.example.listaprova.api.RetrofitClient;
import com.example.listaprova.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    //Implementazione interfaccia per la gestione dei click
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Dichiaro le variabili
    private EditText editTextEmail, editTextPassword, editTextName, editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inizializzo le variabili
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextName = findViewById(R.id.editTextName);
        editTextUsername = findViewById(R.id.editTextUsername);

        //Inizializzazione + interfaccia
        findViewById(R.id.buttonSignUp).setOnClickListener(this);
        findViewById(R.id.textViewLogin).setOnClickListener(this);

    }

    //Preferenze condivise
    @Override
    protected void onStart() {
        super.onStart();

        if(SharedPrefManager.getInstance(this).isLoggedIn()){

            Intent intent = new Intent (this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }

    //Registrazione
    private void userSignUp() {

        //Gestione inserimento testo
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {

            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {

            editTextPassword.setError("Password should be  at least 6 character long");
            editTextPassword.requestFocus();
            return;
        }

        if (name.isEmpty()) {

            editTextName.setError("Name required");
            editTextName.requestFocus();
            return;
        }

        if (username.isEmpty()) {

            editTextUsername.setError("Username required");
            editTextName.requestFocus();
            return;
        }

        //Retrofit
        Call<DefaultResponses> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(email, password, name, username);

        call.enqueue(new Callback<DefaultResponses>() {
            @Override
            public void onResponse(Call<DefaultResponses> call, Response<DefaultResponses> response) {

                if (response.code() == 201) {

                    DefaultResponses dr = response.body();
                    Toast.makeText(MainActivity.this, dr.getMsg(), Toast.LENGTH_SHORT).show();

                }else if (response.code() == 422) {

                    Toast.makeText(MainActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponses> call, Throwable t) {

            }
        });
    }

    //Gestione click bottoni
        @Override
        public void onClick (View v){

            switch (v.getId()) {

                case R.id.buttonSignUp:
                    userSignUp();
                    break;
                case R.id.textViewLogin:
                    startActivity(new Intent(this, LoginActivity.class));
                    break;
            }
        }
    }

