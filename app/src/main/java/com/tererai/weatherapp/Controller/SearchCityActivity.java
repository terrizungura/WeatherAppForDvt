package com.tererai.weatherapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.tererai.weatherapp.R;

public class SearchCityActivity extends AppCompatActivity {

    EditText editCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city);

        editCity = findViewById(R.id.editCity);

        editCity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newCity = editCity.getText().toString();
                Intent intent = new Intent(SearchCityActivity.this, ShowWeatherActivity.class);
                intent.putExtra("City", newCity);
                startActivity(intent);
                return false;
            }
        });
    }
}
