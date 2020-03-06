package com.tererai.weatherapp.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tererai.weatherapp.R;
import com.tererai.weatherapp.adapter.FavoritesAdapter;
import com.tererai.weatherapp.base.FavoritesDbSet;

import io.realm.Realm;

public class FavoritePlacesActivity extends AppCompatActivity {

    RecyclerView favRecycler;

    private Realm rlm;

    FavoritesDbSet favoritesDbSet;

    private final String TAG = ShowWeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_places);

        favRecycler = findViewById(R.id.favRecycler);

        rlm = Realm.getDefaultInstance();
        favoritesDbSet = new FavoritesDbSet(rlm);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "  onResume() called");

        rlm = Realm.getDefaultInstance();

        FavoritesAdapter favoritesAdapter = new FavoritesAdapter(this);
        favoritesAdapter.setFavoritesData(favoritesDbSet.getFavoritesData());
        favRecycler.setAdapter(favoritesAdapter);
        favRecycler.setLayoutManager(new LinearLayoutManager(this));
        favRecycler.setVisibility(View.VISIBLE);

    }
}
