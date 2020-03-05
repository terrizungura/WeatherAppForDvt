package com.tererai.weatherapp.base;

import com.tererai.weatherapp.Model.FavoritesData;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class FavoritesDbSet {

    private Realm r;

    public FavoritesDbSet(Realm realm) {
        r = realm;

    }

    public RealmResults<FavoritesData> getFavoritesData() {

        return r.where(FavoritesData.class).findAll().sort("City");
    }

    public FavoritesData getFavoritesDataByCity(String City) {
        return r.where(FavoritesData.class).equalTo("City", City).findFirst();
    }

    public FavoritesData createFavoritesData(String City) {

        FavoritesData favoritesData = new FavoritesData();
        favoritesData.ID = UUID.randomUUID().toString();
        ;
        favoritesData.City = City;

        r.beginTransaction();

        r.copyToRealm(favoritesData);
        r.commitTransaction();

        return favoritesData;
    }


}
