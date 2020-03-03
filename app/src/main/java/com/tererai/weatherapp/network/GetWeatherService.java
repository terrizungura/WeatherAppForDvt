package com.tererai.weatherapp.network;

import com.tererai.weatherapp.base.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetWeatherService {
    @GET("forecast/")
    Call<WeatherResponse> getWeatherForecast(@Query("appid") String appid, @Query("lon") String longitude,
            @Query("lat") String latitude);

    @GET("forecast/")
    Call<WeatherResponse> getWeatherForCity(@Query("appid") String appid, @Query("q") String city);
}
