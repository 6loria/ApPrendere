package com.example.listaprova.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listaprova.R;
import com.example.listaprova.activities.MainActivity;
import com.example.listaprova.storage.DatabaseHelper;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class ListaFarmaciFragment extends Fragment {

    //Dichiarazioni variabili(UI)
    DatabaseHelper db;
    Button add_data;
    EditText aggiungiNome;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    ListView userList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_lista, container, false);
        setHasOptionsMenu(true);

        //Inizializzazione delle variabili(UI) e del db
        db = new DatabaseHelper(getActivity());

        listItem = new ArrayList<>();

        add_data = view.findViewById(R.id.add_data);
        aggiungiNome = view.findViewById(R.id.addFarmaco);
        userList = view.findViewById(R.id.users_list);


        //Invocazione metodo visualizza dati
        viewData();


        //Gestione "click" listview
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = userList.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), ""+text, LENGTH_SHORT).show();
            }
        });


        //Gestione evento "click" aggiungo farmaco al database
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome =  aggiungiNome.getText().toString();
                if(!nome.equals("") && db.inserisciDati(nome)){

                    Toast.makeText(getActivity(), "Farmaco aggiunto", LENGTH_SHORT).show();
                    aggiungiNome.setText("");
                    listItem.clear();

                }else {

                    Toast.makeText(getActivity(), "Farmaco non aggiunto", LENGTH_SHORT).show();

                }
            }
        });


        return view;
    }

    //Visualizza i dati nella listView
    private void viewData() {
        Cursor cursor = db.viewData();

        //Gestione eccezione cursore vuoto
        if (cursor.getCount() == 0) {

            Toast.makeText(getActivity(), "Non ci sono farmaci nella lista", LENGTH_SHORT).show();

        } else {

            while(cursor.moveToNext()){

                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, listItem );
            userList.setAdapter(adapter);
        }
    }


        //Gestione menu
        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

           inflater.inflate(R.menu.menu, menu);

            MenuItem searchItem = menu.findItem(R.id.item_search);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);



        //Ricerca
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> farmacoList = new ArrayList<>();

                for(String farmaco : listItem){
                    if(farmaco.toLowerCase().contains(newText.toLowerCase())){

                        farmacoList.add(farmaco);

                    }
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, farmacoList);
                userList.setAdapter(adapter);

                return true;
            }
        });

            super.onCreateOptionsMenu(menu, inflater);
    }

    }






