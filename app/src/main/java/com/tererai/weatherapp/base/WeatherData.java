package com.tererai.weatherapp.base;

import androidx.annotation.Nullable;

import com.tererai.weatherapp.utils.DateUtil;

public class WeatherData {
    private Double Fahrenheit = 273.15;
    private String mCurrentCondition;
    private String mDay;
    private int mTemperature;
    private int mMinTemperature;
    private int mMaxTemperature;

    public WeatherData(WeatherResponseList weatherResponse) {
        java.util.List<Weather> weatherList = weatherResponse.getWeather();
        this.mTemperature = (int) (weatherResponse.getMain().getTemp() - Fahrenheit);
        this.mMinTemperature = (int) (weatherResponse.getMain().getTempMin() - Fahrenheit);
        this.mMaxTemperature = (int) (weatherResponse.getMain().getTempMax() - Fahrenheit);
        this.mCurrentCondition = weatherList.get(0).getMain();
        this.mDay = DateUtil.getDay(weatherResponse.getDtTxt());
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof WeatherData)) {
            return false;
        }

        WeatherData inputWeatherData = (WeatherData) obj;
        return inputWeatherData.getmDay().toLowerCase().equals(this.getmDay().toLowerCase());
    }

    public String getmCurrentCondition() {
        return mCurrentCondition;
    }

    public void setmCurrentCondition(String mCurrentCondition) {
        this.mCurrentCondition = mCurrentCondition;
    }

    public String getmDay() {
        return mDay;
    }

    public void setmDay(String mDay) {
        this.mDay = mDay;
    }

    public int getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(int mTemperature) {
        this.mTemperature = mTemperature;
    }

    public int getmMinTemperature() {
        return mMinTemperature;
    }

    public void setmMinTemperature(int mMinTemperature) {
        this.mMinTemperature = mMinTemperature;
    }

    public int getmMaxTemperature() {
        return mMaxTemperature;
    }

    public void setmMaxTemperature(int mMaxTemperature) {
        this.mMaxTemperature = mMaxTemperature;
    }

}
