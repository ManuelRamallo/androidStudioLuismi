package com.mrdiaz.apptiempo;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mrdiaz on 14/02/2018.
 */

public class ServiceGenerator {

    private static final String BASE_URL = "https://api.openweathermap.org/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(
                            GsonConverterFactory.create()
                    );

    private static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static  OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();


    /*Interceptor googlePlaceInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("key", "AIzaSyDjpqKUMLVPGvqVUhjiCq2LTPz1rTvEeFw")
                    .build();

            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request);


        }
    };*/


    public static <S> S createService(
            Class<S> serviceClass) {

        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("APPID", "76bbda59052636881e21fb70f0eacf35")
                            .addQueryParameter("units", "motric")
                            .addQueryParameter("lang", "es")
                            .build();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });

            builder.client(httpClient.build());
            retrofit = builder.build();
        }



        return retrofit.create(serviceClass);
    }



}
