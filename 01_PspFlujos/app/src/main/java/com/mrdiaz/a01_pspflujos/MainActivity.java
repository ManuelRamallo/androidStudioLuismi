package com.mrdiaz.a01_pspflujos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OutputStreamWriter writer = null;
        FileOutputStream fout = null;

        try {
            //fout = openFileOutput("file.dat", Context.MODE_PRIVATE);
            //writer = new OutputStreamWriter(fout);

            writer = new OutputStreamWriter(openFileOutput("file.txt", Context.MODE_PRIVATE));

            writer.write("Hola mundo");
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(writer != null)
                try{
                    writer.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
        }

        BufferedReader reader = null;

        TextView txt = findViewById(R.id.texto);

        try{

            //Buffered le pide la informacion al input que le va a pedir la informacion al fileInputStream
            reader = new BufferedReader( new InputStreamReader(openFileInput("file.txt")));

            String str = null;

            while((str  = reader.readLine()) != null){
                Log.d("FILE", str);
                txt.setText(str);
            }


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try{
                    fout.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
        }

    }
}
