package com.tererai.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tererai.weatherapp.Model.FavoritesData;
import com.tererai.weatherapp.R;

import java.util.List;

public class FavoritePlacesAdapter extends ArrayAdapter<FavoritesData> {

    private Context mContext;
    private int mResource;

    private static class ViewHolder {
        TextView name;
    }

    public FavoritePlacesAdapter(@NonNull Context context, int resource, @NonNull List<FavoritesData> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String name = getItem(position).City;

        final View result;
        //ViewHolder object
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent,false);
            holder = new ViewHolder();
            holder.name  = convertView.findViewById(R.id.favorites_list_item);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        holder.name.setText(name);

        return convertView;
    }
}
