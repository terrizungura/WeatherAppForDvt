package com.tererai.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tererai.weatherapp.R;
import com.tererai.weatherapp.base.WeatherData;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private final LayoutInflater mInflater;
    private final Context mContext;
    private List<WeatherData> mWeatherResponse;

    public WeatherAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_weather_days, parent, false);
        return new WeatherViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return (null == mWeatherResponse || mWeatherResponse.isEmpty()) ? 0 : mWeatherResponse.size();
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        if (!mWeatherResponse.isEmpty()) {
            WeatherData weatherResponse = mWeatherResponse.get(position);
            holder.dayText.setText(weatherResponse.getmDay());
            holder.temperatureText.setText(mContext.getString(R.string.temp_si_unit,
                    weatherResponse.getmTemperature()));
            holder.sunImage.setImageResource(updateDailyIcons(weatherResponse.getmCurrentCondition()));
        }
    }

    public void setWeatherResponse(List<WeatherData> weatherResponse) {
        mWeatherResponse = weatherResponse;
        notifyDataSetChanged();
    }

    private int updateDailyIcons(String condition) {
        switch (condition){
            case "Rain":
                return R.drawable.rain2x;
            case "Clouds":
                return R.drawable.rain3x;
            case "Clear":
                return R.drawable.clear2x;
            default:
                return R.drawable.partlysunny2x;
        }
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.day_text) TextView dayText;
        @BindView(R.id.sun_image) ImageView sunImage;
        @BindView(R.id.temperature_text) TextView temperatureText;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
