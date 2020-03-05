package com.tererai.weatherapp.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeather


{
    private String visibility;

    private String timezone;

    @SerializedName("main")
    @Expose
    private Main main;

    private String dt;

    private Weather[] weather;

    private String name;

    private String cod;

    private String id;

    private String base;

    public String getVisibility ()
    {
        return visibility;
    }

    public void setVisibility (String visibility)
    {
        this.visibility = visibility;
    }

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public Main getMain ()
    {
        return main;
    }

    public void setMain (Main main)
    {
        this.main = main;
    }

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public Weather[] getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather[] weather)
    {
        this.weather = weather;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBase ()
    {
        return base;
    }

    public void setBase (String base)
    {
        this.base = base;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [visibility = "+visibility+", timezone = "+timezone+", main = "+main+", dt = "+dt+", weather = "+weather+", name = "+name+", cod = "+cod+", id = "+id+", base = "+base+"]";
    }
}