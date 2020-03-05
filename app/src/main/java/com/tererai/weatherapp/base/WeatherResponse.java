package com.tererai.weatherapp.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
    @SerializedName("list")
    @Expose
    private java.util.List<WeatherResponseList> weatherResponseList = null;
    private City city = null;
    private CurrentWeather currentWeather = null;

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public java.util.List<WeatherResponseList> getWeatherResponseList() {
        return weatherResponseList;
    }

    public void setWeatherResponseList(java.util.List<WeatherResponseList> weatherResponseList) {
        this.weatherResponseList = weatherResponseList;
    }

}
