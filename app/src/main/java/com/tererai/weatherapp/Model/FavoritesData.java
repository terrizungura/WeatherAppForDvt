package com.tererai.weatherapp.Model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FavoritesData extends RealmObject {

    @PrimaryKey
public String ID;
public String City;
public String CurrentCondition;
public String MinTemp;
public String CurrentTemp;
public String MaxTemp;
public Double Longitude;
public Double Latitude;

public FavoritesData(){

}

}
