package com.example.listaprova.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listaprova.R;
import com.example.listaprova.activities.LoginActivity;
import com.example.listaprova.api.RetrofitClient;
import com.example.listaprova.models.DefaultResponses;
import com.example.listaprova.models.LoginResponse;
import com.example.listaprova.models.User;
import com.example.listaprova.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

//Implemento interfaccia per la gestione dei click dei bottoni
public class ImpostazioniFragment extends Fragment implements  View.OnClickListener {

    //Dichiarazione Variabili
    EditText editTextEmail, editTextName, editTextUsername;
    EditText editTextCurrentPassword, editTextNewPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_impostazioni, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Inizializzo le variabili
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextName = view.findViewById(R.id.editTextName);
        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextNewPassword = view.findViewById(R.id.editTextNewPassword);
        editTextCurrentPassword = view.findViewById(R.id.editTextCurrentPassword);

       //Gestione eventi click dei bottoni
        view.findViewById(R.id.buttonLoginSave).setOnClickListener(this);
        view.findViewById(R.id.buttonChangePassword).setOnClickListener(this);
        view.findViewById(R.id.buttonLogout).setOnClickListener(this);
        view.findViewById(R.id.buttonDelete).setOnClickListener(this);

    }

    //Aggiorna profilo
    private void aggiornaProfilo(){

        //Passo i dati inseriti in variabili di tipo String
        String email = editTextEmail.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();

        //Controllo sul tipo di dato inserito
        if(email.isEmpty()){

            editTextEmail.setError("Devi inserire la mail");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Inserisci una mail valida");
            editTextEmail.requestFocus();
            return;
        }

        if (name.isEmpty()) {
            editTextName.setError("Devi inserire un nome");
            editTextName.requestFocus();
            return;
        }

        if (username.isEmpty()) {
            editTextUsername.setError("Devi inserire un username");
            editTextUsername.requestFocus();
            return;
        }

        //Utente non aggiornato
        User user = SharedPrefManager.getInstance(getActivity()).getUser();

        Call<LoginResponse> call = RetrofitClient.getInstance()
                .getApi().updateUser(
                        user.getId(),
                        email,
                        name,
                        username
                );

        //Gestione risposta e parsing
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                //Se non ci sono errori salva l'utente aggiornato nelle preferenze condivise
                if(!response.body().isError()){

                    SharedPrefManager.getInstance(getActivity()).saveUser(response.body().getUser());

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {



            }
        });


    }

    //Aggiorna password
    private void aggiornaPassword(){

        //Inserimento dati
        String currentpassword = editTextCurrentPassword.getText().toString().trim();
        String newpassword = editTextNewPassword.getText().toString().trim();

        //Controllo inserimento password corrente e nuova
        if(currentpassword.isEmpty()){

            editTextCurrentPassword.setError("Inserisci la password");
            editTextNewPassword.requestFocus();
            return;

        }

        if(newpassword.isEmpty()){

            editTextCurrentPassword.setError("Inserisci la password");
            editTextNewPassword.requestFocus();
            return;

        }

        //Recupero l'utente dalle preferenze condivise
        User user = SharedPrefManager.getInstance((getActivity())).getUser();

        Call<DefaultResponses> call =  RetrofitClient.getInstance().getApi()
                .updatePassword(currentpassword, newpassword, user.getEmail());

        call.enqueue(new Callback<DefaultResponses>() {
            @Override
            public void onResponse(Call<DefaultResponses> call, Response<DefaultResponses> response) {

                Toast.makeText(getActivity(), response.body().getMsg(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<DefaultResponses> call, Throwable t) {

            }
        });

    }

    //Logout
    private void logout(){

        SharedPrefManager.getInstance(getActivity()).clear();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    //Elimina profilo
    private void cancellaProfilo(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Vuoi cancellare il profilo?");
        builder.setMessage("Non potrai ripristinare il profilo...");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                User user = SharedPrefManager.getInstance(getActivity()).getUser();
                Call<DefaultResponses> call  = RetrofitClient.getInstance().getApi().deleteUser(user.getId());

                call.enqueue(new Callback<DefaultResponses>() {
                    @Override
                    public void onResponse(Call<DefaultResponses> call, Response<DefaultResponses> response) {

                        if(!response.body().isErr()){

                            SharedPrefManager.getInstance(getActivity()).clear();
                            Intent intent = new Intent(getActivity(), LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        }

                        Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<DefaultResponses> call, Throwable t) {

                    }
                });
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog ad = builder.create();
        ad.show();

    }

    //Gestione click
    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.buttonLoginSave:
                aggiornaProfilo();
                break;
            case R.id.buttonChangePassword:
                aggiornaPassword();
                break;
            case R.id.buttonLogout:
                logout();
                break;
            case R.id.buttonDelete:
                cancellaProfilo();
                break;
        }

    }
}
