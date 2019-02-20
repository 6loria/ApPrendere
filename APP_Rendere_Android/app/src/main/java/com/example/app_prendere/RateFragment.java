package com.example.app_prendere;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateFragment extends Fragment {

    RatingBar ratingBar;
    Button button;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rate,container,false);

          ratingBar =   view.findViewById(R.id.ratingBar) ;
          button = view.findViewById(R.id.button);
          ratingBar.setNumStars(5);



          ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
              @Override
              public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                  Toast.makeText( RateFragment.this.getContext(),"Stars:  " + rating, Toast.LENGTH_SHORT).show();

              }
          });


          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(RateFragment.this.getContext(),"Stars:  " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();

              }
          });

          return view;





    }
}
