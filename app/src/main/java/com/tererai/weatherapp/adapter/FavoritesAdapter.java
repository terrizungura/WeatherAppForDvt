package com.tererai.weatherapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tererai.weatherapp.Controller.ShowWeatherActivity;
import com.tererai.weatherapp.Model.FavoritesData;
import com.tererai.weatherapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder>{

    private final LayoutInflater mInflater;
    private final Context mContext;
    private List<FavoritesData> mFavoritesData;
    String mCity;

    public FavoritesAdapter(Context mContext) {
        this.mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_for_adapters, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(!mFavoritesData.isEmpty()){
            FavoritesData favoritesData = mFavoritesData.get(position);
            holder.favorite_list_item.setText(favoritesData.City);
            holder.favoritesContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCity = favoritesData.City;
                    Intent intent = new Intent(mContext, ShowWeatherActivity.class);
                    intent.putExtra("City", mCity);
                    mContext.startActivity(intent);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return (null == mFavoritesData || mFavoritesData.isEmpty()) ? 0: mFavoritesData.size();
    }

    public void setFavoritesData(List<FavoritesData> theFavoritesData) {
        mFavoritesData = theFavoritesData;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.favorites_list_item) TextView favorite_list_item;
        @BindView(R.id.rcView) LinearLayout favoritesContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
