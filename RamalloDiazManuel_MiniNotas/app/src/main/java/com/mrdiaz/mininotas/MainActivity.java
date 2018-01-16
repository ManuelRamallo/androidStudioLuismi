package com.mrdiaz.mininotas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button botonGuardar = findViewById(R.id.botonGuardar);
        final EditText textoMultilinea = findViewById(R.id.textoMultilinea);


        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrintWriter writer = null;

                try {
                    writer = new PrintWriter(new OutputStreamWriter(openFileOutput("text.txt", Context.MODE_PRIVATE)));
                    writer.write(textoMultilinea.getText().toString());
                    Log.i( "Texto que se guarda: ",textoMultilinea.getText().toString());
                    Toast.makeText(MainActivity.this, "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    if (writer != null)
                        writer.close();
                }
            }
        });

        BufferedReader reader = null;

        try {
            reader = new BufferedReader( new InputStreamReader(openFileInput("text.txt")));

            String texto = null;

            while((texto  = reader.readLine()) != null){
                Log.d("FILE", texto);
                textoMultilinea.setText(texto);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try{
                    reader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
        }


    }


}
