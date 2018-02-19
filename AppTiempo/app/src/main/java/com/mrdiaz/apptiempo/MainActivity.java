package com.mrdiaz.apptiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mrdiaz.apptiempo.model.weather.WeatherInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Paso 1: Generar el servicio completo
        ApiOpenWeather openWeatherApi = ServiceGenerator.createService(ApiOpenWeather.class);

        //Paso 2: Invocar al servicio concreto
        Call<WeatherInfo> peticion = openWeatherApi.getWeatherByCity("Ubeda");

        //Paso 3: Invocar al método enqueue (ejecutar la peticion asincronamente)
        peticion.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if(response.isSuccessful()){
                    WeatherInfo weatherInfo = response.body();
                    Log.i("Retrofit OK", weatherInfo.toString());
                } else {
                    Toast.makeText(MainActivity.this, "Lo sentimos, pero ocurrío algun problema dentro de OnResponse", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Lo sentimos, pero ocurrio algun problema OnFailure", Toast.LENGTH_SHORT).show();
                Log.e("Retrofit fail", t.toString());
            }
        });





    }
}
