package com.example.listaprova.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.listaprova.R;
import com.example.listaprova.fragments.AllarmiFragment;
import com.example.listaprova.fragments.HomeFragment;
import com.example.listaprova.fragments.ImpostazioniFragment;
import com.example.listaprova.fragments.ListaFarmaciFragment;
import com.example.listaprova.models.User;
import com.example.listaprova.storage.SharedPrefManager;

//Implemento interfaccia
public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //Dichiarazione variabili


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Inizializzo le variabili
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        //Gestione click
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        displayFragment(new HomeFragment());

    }

    //Mostra fragment
    private void displayFragment( Fragment fragment){

       getSupportFragmentManager()
               .beginTransaction()
               .replace(R.id.relativeLayout, fragment)
               .commit();
    }

    //Preferenze Condivise
    @Override
    protected void onStart() {
        super.onStart();

        if(SharedPrefManager.getInstance(this).isLoggedIn()){

            Intent intent = new Intent (ProfileActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }

    //Gestione click fragment
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        //Creo un oggetto fragment
        Fragment fragment = null;

        switch(menuItem.getItemId()){

            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_farmaci:
                fragment = new ListaFarmaciFragment();
                break;
            case R.id.menu_impostazioni:
                fragment = new ImpostazioniFragment();
                break;
            case R.id.menu_allarme:
                fragment = new AllarmiFragment();
                break;

        }
        if(fragment != null){

            displayFragment(fragment);
        }
        return false;
    }
}
