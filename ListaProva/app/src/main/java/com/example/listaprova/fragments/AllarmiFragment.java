package com.example.listaprova.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.listaprova.R;

public class AllarmiFragment extends Fragment {
    FloatingActionButton aggiungiAllarme;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_allarmi, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        aggiungiAllarme = getView().findViewById(R.id.add_reminder);

        aggiungiAllarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Fragment editAllarme = new EditAllarme();
            getFragmentManager().beginTransaction().replace(R.id.relativeLayout, editAllarme).commit();

            }
        });


   }

}
