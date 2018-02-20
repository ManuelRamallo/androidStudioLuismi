package com.mrdiaz.apigoogleplacesproject;


import com.mrdiaz.apigoogleplacesproject.PrediccionResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mrdiaz on 19/02/2018.
 */

public interface GooglePlacesApi {

    @GET("/maps/api/place/autocomplete/json")
    Call<PrediccionResult> autoComplete(@Query("input") String text);

}
