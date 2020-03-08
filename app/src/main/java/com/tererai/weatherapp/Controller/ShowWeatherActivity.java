package com.tererai.weatherapp.Controller;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.tererai.weatherapp.Model.FavoritesData;
import com.tererai.weatherapp.R;
import com.tererai.weatherapp.adapter.WeatherAdapter;
import com.tererai.weatherapp.base.CurrentWeather;
import com.tererai.weatherapp.base.FavoritesDbSet;
import com.tererai.weatherapp.base.WeatherData;
import com.tererai.weatherapp.base.WeatherResponse;
import com.tererai.weatherapp.base.WeatherResponseList;
import com.tererai.weatherapp.network.GetWeatherService;
import com.tererai.weatherapp.network.RetrofitClientInstance;

import butterknife.OnClick;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class ShowWeatherActivity extends AppCompatActivity {

    @BindView(R.id.temp_recyclerview)
    RecyclerView daysRecyclerview;
    @BindView(R.id.txtCurrentTemp)
    TextView txtCurrentTempHeader;
    @BindView(R.id.no_data)
    TextView txtNoData;
    @BindView(R.id.txtCurrentCondition)
    TextView txtCurrentConditions;
    @BindView(R.id.summary_layout)
    ConstraintLayout summaryLayout;
    @BindView(R.id.min_temp_text)
    TextView txtMinTemp;
    @BindView(R.id.current_temp_text)
    TextView txtCurrentTemp;
    @BindView(R.id.max_temp_text)
    TextView txtMaxTemp;
    @BindView(R.id.txtCity)
    TextView txtCity;
    @BindView(R.id.imgMainIcon)
    ImageView imgMainIcon;
    @BindView(R.id.showWeatherView)
    ConstraintLayout showWeatherView;
    @BindView(R.id.imgFavorite)
    ImageView imgFavorite;
    @BindDrawable(R.drawable.fav)
    Drawable fav;

    private ProgressDialog progressDialog;
    private LocationManager mLocationManager;
    private LocationListener mLocationListener;

    private FavoritesDbSet favoritesDbSet;

    private Realm rlm;

    private final int REQUEST_CODE = 123;
    private double Fahrenheit = 273.15;
    private final String TAG = ShowWeatherActivity.class.getSimpleName();
    String LOCATION_PROVIDER = LocationManager.GPS_PROVIDER;

    private final String APP_ID = "728e7483dddb8d88cfdc006408674a1b";
    // Time between location updates (8000 milliseconds or 5 seconds)
    private final long MIN_TIME = 8000;
    // Distance between location updates (1000m or 1km)
    private final float MIN_DISTANCE = 1000;
    private final String RAIN_CONDITION = "Rain";
    private final String CLOUD_CONDITION = "Clouds";
    private final String CLEAR_CONDITION = "Clear";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_weather);
        ButterKnife.bind(this);

        imgFavorite.setImageDrawable(fav);

        Realm.init(this);
        rlm = Realm.getDefaultInstance();

    }

    @OnClick(R.id.imgFavorite)
    public void saveFavorites() {

        favoritesDbSet = new FavoritesDbSet(rlm);
        FavoritesData favoritesData;
        favoritesData = favoritesDbSet.createFavoritesData(txtCity.getText().toString());
        rlm.beginTransaction();

        favoritesData.City = txtCity.getText().toString();
        favoritesData.CurrentCondition = txtCurrentConditions.getText().toString();
        favoritesData.CurrentTemp = txtCurrentTemp.getText().toString();
        favoritesData.MinTemp = txtMinTemp.getText().toString();
        favoritesData.MaxTemp = txtMaxTemp.getText().toString();

        rlm.insertOrUpdate(favoritesData);
        rlm.commitTransaction();
        imgFavorite.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_city:
                Intent intentSearch = new Intent(ShowWeatherActivity.this, SearchCityActivity.class);
                startActivity(intentSearch);
                return true;
            case R.id.favorites:
                Intent intentFavPlace = new Intent(ShowWeatherActivity.this, FavoritePlacesActivity.class);
                startActivity(intentFavPlace);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showHideProgressDialog(boolean show) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        if (show) {
            progressDialog.setMessage("Loading weather data...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
            progressDialog.setCancelable(true);
            Runnable progressRunnable = new Runnable() {

                @Override
                public void run() {
                    progressDialog.cancel();

                }
            };

            Handler pdCanceller = new Handler();
            pdCanceller.postDelayed(progressRunnable, 15000);
        } else {
            progressDialog.cancel();
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWeatherForCurrentLocation();
    }

    private void getWeatherForCurrentLocation() {
        showHideProgressDialog(true);
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d(TAG, "onLocationChanged() called");
                getWeatherForecast(location);
                getWeatherCurrent(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d(TAG, "onProviderDisabled() called");
            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {

            ActivityCompat
                    .requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        mLocationManager.requestLocationUpdates(LOCATION_PROVIDER, MIN_TIME, MIN_DISTANCE, mLocationListener);
    }

    private void getWeatherForecast(Location location) {
        String longitude = String.valueOf(location.getLongitude());
        String latitude = String.valueOf(location.getLatitude());
        Intent myIntent = getIntent();
        String city = myIntent.getStringExtra("City");

        GetWeatherService weatherService = RetrofitClientInstance.getRetrofitInstance().create(GetWeatherService.class);
        Call<WeatherResponse> call;
        if (city != null) {
            call = weatherService.getWeatherForCity(APP_ID, city);
            Log.d(TAG, "getWeatherForCity() called");

        } else {
            call = weatherService.getWeatherForecast(APP_ID, longitude, latitude);
            Log.d(TAG, "getWeatherForecast() called");
        }

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.body() != null) {
                    showHideProgressDialog(false);
                    populateUIs(response.body());
                } else {
                    showHideProgressDialog(false);
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                showError(t);
            }
        });
    }

    private void getWeatherCurrent(Location location) {
        String longitude = String.valueOf(location.getLongitude());
        String latitude = String.valueOf(location.getLatitude());
        Intent myIntent = getIntent();
        String city = myIntent.getStringExtra("City");

        GetWeatherService weatherService = RetrofitClientInstance.getRetrofitInstance().create(GetWeatherService.class);
        Call<CurrentWeather> call;
        if (city != null) {
            call = weatherService.getWeatherCurrentForCity(APP_ID, city);
            Log.d(TAG, "getWeatherForCity() called");

        } else {
            call = weatherService.getWeatherCurrent(APP_ID, longitude, latitude);
            Log.d(TAG, "getWeatherForecast() called");
        }

        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (response.body() != null) {
                    showHideProgressDialog(false);
                    populateOtherUIs(response.body());
                } else {
                    showHideProgressDialog(false);
                }
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                showError(t);
            }
        });
    }

    private void showError(Throwable throwable) {
        Log.e(TAG, "Error: " + throwable.getMessage());
        showHideProgressDialog(false);
        Toast.makeText(this, " Cannot get data for the location", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ;
            }
            Log.d(TAG, "permission granted");
            getWeatherForCurrentLocation();
        } else {
            Log.d(TAG, "permissions denied");
        }
    }

    private int updateDailyIcons(WeatherData weatherData) {
        String CurrentCondition = weatherData.getmCurrentCondition();
        txtCurrentConditions.setText(CurrentCondition.toUpperCase());
        updateBackgroundColor(CurrentCondition);
        switch (CurrentCondition) {
            case RAIN_CONDITION:
                return R.drawable.forest_rainy;
            case CLOUD_CONDITION:
                return R.drawable.forest_cloudy;
            case CLEAR_CONDITION:
            default:
                return R.drawable.forest_sunny;
        }
    }

    private List<WeatherData> getWeatherData(
            java.util.List<WeatherResponseList> weatherResponseLists) {
        List<WeatherData> weatherDataList = new ArrayList<>();
        for (WeatherResponseList item : weatherResponseLists) {
            WeatherData weatherData = new WeatherData(item);
            if (!weatherDataList.contains(weatherData)) {
                weatherDataList.add(weatherData);
            }
        }
        return weatherDataList;
    }

    private void populateUIs(WeatherResponse weatherResponse) {
        if (weatherResponse != null && !weatherResponse.getWeatherResponseList().isEmpty()) {
            Log.d(TAG, "populateUIs() :weatherResponse.getWeatherResponseList()");

            WeatherAdapter adapter = new WeatherAdapter(this);
            List<WeatherData> weatherDataList =
                    getWeatherData(weatherResponse.getWeatherResponseList());
            adapter.setWeatherResponse(weatherDataList);

            daysRecyclerview.setAdapter(adapter);
            daysRecyclerview.setLayoutManager(new LinearLayoutManager(this));
            daysRecyclerview.setVisibility(View.VISIBLE);
            txtNoData.setVisibility(View.GONE);
            txtCity.setText(weatherResponse.getCity().getName());

            populateSummary(weatherDataList);
        } else {
            daysRecyclerview.setVisibility(View.GONE);
            txtNoData.setVisibility(View.VISIBLE);
        }
    }

    private void populateOtherUIs(CurrentWeather currentWeatherResponse) {
        if (currentWeatherResponse != null && !currentWeatherResponse.getWeather().isEmpty()) {

            txtNoData.setVisibility(View.GONE);

            txtCurrentTemp.setText(getFormattedTemperature(currentWeatherResponse.getMain().getTemp()));
            txtCurrentTempHeader.setText(getFormattedTemperature(currentWeatherResponse.getMain().getTemp()));

        } else {
            txtNoData.setVisibility(View.VISIBLE);
        }
    }

    private String getFormattedTemperature(Double temp){
        int temperature = (int)(temp - Fahrenheit);
        return getString(R.string.temp_si_unit, temperature);
    }

    private void populateSummary(List<com.tererai.weatherapp.base.WeatherData> weatherDataList) {
        com.tererai.weatherapp.base.WeatherData weatherData = weatherDataList.get(0);

        imgMainIcon.setImageResource(updateDailyIcons(weatherData));
        txtMinTemp.setText(getString(R.string.temp_si_unit, weatherData.getmMinTemperature()));
        txtMaxTemp.setText(getString(R.string.temp_si_unit, weatherData.getmMaxTemperature()));

    }

    private void updateBackgroundColor(String currentCond) {
        currentCond = currentCond.toLowerCase();
        if ((currentCond.contains(CLEAR_CONDITION.toLowerCase()))) {
            showWeatherView.setBackgroundColor(getResources().getColor(R.color.colorSunny));
        } else if ((currentCond.contains(CLOUD_CONDITION.toLowerCase()))) {
            showWeatherView.setBackgroundColor(getResources().getColor(R.color.cloudy));
        } else if ((currentCond.contains(RAIN_CONDITION.toLowerCase()))) {
            showWeatherView.setBackgroundColor(getResources().getColor(R.color.rainy));
        }
    }
}


