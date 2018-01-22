package com.mrdiaz.retrofit;

import android.support.annotation.RestrictTo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mrdiaz on 22/01/2018.
 */

public class ServiceGenerator {

    private static final String BASE_URL = "https://api.github.com/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();


    /*Retrofit retrofit =
            builder
                    .client(httpClient.build())
                    .build();*/

    public static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
