package com.tererai.weatherapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.tererai.weatherapp.Model.FavoritesData;
import com.tererai.weatherapp.R;
import com.tererai.weatherapp.adapter.FavoritePlacesAdapter;
import com.tererai.weatherapp.base.FavoritesDbSet;

import io.realm.Realm;

public class FavoritePlacesActivity extends AppCompatActivity {

    ListView the_favorites;

    private Realm rlm;

    FavoritesDbSet favoritesDbSet;

    private final String TAG = ShowWeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_places);

        the_favorites = findViewById(R.id.the_favorites);

        rlm = Realm.getDefaultInstance();
        favoritesDbSet = new FavoritesDbSet(rlm);

        the_favorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String newCity = the_favorites.getItemAtPosition(position).toString();
                Log.d(TAG, newCity);
                Intent intent = new Intent(FavoritePlacesActivity.this, ShowWeatherActivity.class);
                //intent.putExtra("City", newCity);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        rlm = Realm.getDefaultInstance();

        final FavoritePlacesAdapter favoritePlacesAdapter = new FavoritePlacesAdapter(this, R.layout.adapter_layout, favoritesDbSet.getFavoritesData());
        the_favorites.setAdapter(favoritePlacesAdapter);


    }

    private void initializeEventHandler() {
        the_favorites.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //FavoritesData clickedCity = favoritePlacesAdapter;
                Log.d("zzzz", "tadana");
                String newCity = the_favorites.getItemAtPosition(position).toString();
                Toast.makeText(FavoritePlacesActivity.this, newCity + " selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FavoritePlacesActivity.this, ShowWeatherActivity.class);
                //intent.putExtra("City", newCity);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
