package com.mrdiaz.apptiempo;

import com.mrdiaz.apptiempo.model.weather.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mrdiaz on 14/02/2018.
 */

public interface ApiOpenWeather {

    //@GET("/weather?APPID=42340047f711beb90d6e58a202eab107&units=metric&lang=es")
    @GET("/data/2.5/weather")
    Call<WeatherInfo> getWeatherByCity(@Query("q") String city);
}
