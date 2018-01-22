package com.mrdiaz.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lista);

        /*GitHubAdapter GithubRepo = new GitHubAdapter(
                this, android.R.layout.simple_expandable_list_item_1, listView);*/

        /*
                            ////////////////////////////////////////////////////
                    //////////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////////////////

        ESTE CODIGO LO VA A SUBIR AL REPOSITORIO, TERMINAR DE COMPLETAR CON LO DEL REPOSITORIO DE LUISMI

            //////////////////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////
                            ////////////////////////////////////////////////////
        */


        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);
        //retrofit.create(GitHubClient.class);

        Call<List<GitHubRepo>> call = client.reposForUser("fs-opensource");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> result = response.body();
                int statusCode = response.code();
                Log.i("RESULT", "status code: " + statusCode);

                for(GitHubRepo repo: result){
                    Log.i("RESULT", "nombre repositorio: " + repo.getName());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });

    }
}
