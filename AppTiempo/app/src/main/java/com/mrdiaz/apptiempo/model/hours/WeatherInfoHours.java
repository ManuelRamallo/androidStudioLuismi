
package com.mrdiaz.apptiempo.model.hours;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherInfoHours {

    @SerializedName("city")
    @Expose
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
