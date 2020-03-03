package com.tererai.weatherapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static Retrofit retrofitCurrent;
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String BASE_URL_CURRRENT = "http://api.openweathermap.org/data/2.5/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getRetrofitInstanceCurrent() {
        if (retrofitCurrent == null) {
            retrofitCurrent = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL_CURRRENT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitCurrent;
    }
}
