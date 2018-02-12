package com.mrdiaz.retrofitobjects12022018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editTextTitulo, editTextBody, editTextUserId;
    Button buttonEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextTitulo = findViewById(R.id.editTextTitulo);
        editTextUserId = findViewById(R.id.editTextUserId);
        editTextBody = findViewById(R.id.editTextBody);
        buttonEnviar = findViewById(R.id.buttonEnviar);



        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TaskModel tsModel = new TaskModel();

                tsModel.setUserId(Integer.parseInt(editTextUserId.getText().toString()));
                tsModel.setTitle(editTextTitulo.getText().toString());
                tsModel.setBody(editTextBody.getText().toString());


                TaskService client = ServiceGenerator.createService(TaskService.class);
                Call<TaskModel> call = client.createTask(tsModel);


                call.enqueue(new Callback<TaskModel>() {
                    @Override
                    public void onResponse(Call<TaskModel> call, Response<TaskModel> response) {
                        if (response.code() == 201){
                            Toast.makeText(MainActivity.this, "Post realizado correctamente!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Fallo al hacer el Post", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<TaskModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Fallo en onFailure", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });



    }
}
