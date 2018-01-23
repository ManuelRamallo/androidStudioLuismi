package com.example.lmlopez.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        listView = findViewById(R.id.listView);

        GitHubClient client =
                ServiceGenerator.createService(GitHubClient.class);
                        //retrofit.create(GitHubClient.class);

        Call<List<GitHubRepo>> call =
                client.reposForUser("fs-opensource");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> result = response.body();
                int statusCode = response.code();
                /*Log.i("RESULT", "Status Code: " + statusCode);
                for(GitHubRepo repo: result ) {
                    Log.i("RESULT", repo.getName());
                }*/
                listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, result));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });


    }
}
