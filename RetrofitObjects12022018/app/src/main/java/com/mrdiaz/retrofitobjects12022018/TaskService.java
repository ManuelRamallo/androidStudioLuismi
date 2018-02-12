package com.mrdiaz.retrofitobjects12022018;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by mrdiaz on 12/02/2018.
 */

public interface TaskService {

    @POST("/posts")
    Call<TaskModel> createTask(@Body TaskModel TaskModel);

}
