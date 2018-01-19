package com.mrdiaz.a02_asynctask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imagenLogo);

        new MyImageDownloadAsyncTask().execute();

    }


    private class MyImageDownloadAsyncTask extends AsyncTask<Void, Integer, Bitmap>{

        ProgressDialog pd;

        //Paso 1
        @Override
        protected void onPreExecute() {

            pd = new ProgressDialog(MainActivity.this);

            //Set progress dialog style spinner
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            //set the progess dialog title and message
            pd.setTitle("Title of progress dialog.");
            pd.setMessage("Loading....");

            pd.setIndeterminate(true);

            //Finally, show the progress dialog
            pd.show();
        }

        //Paso 2
        @Override
        protected Bitmap doInBackground(Void... voids) {

            URL urlImage = null;
            Bitmap imagen = null;

            try {
                urlImage = new URL("http://jsequeiros.com/sites/default/files/imagen-cachorro-comprimir.jpg");
                for(int i=0; i<5; i++){
                    imagen = BitmapFactory.decodeStream(urlImage.openStream());
                    publishProgress(i+1);}
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return imagen;
        }

        //Paso 3
        @Override
        protected void onProgressUpdate(Integer... values) {
            //super.onProgressUpdate(values);
            int value =  values[0];
            pd.setMessage(value + " of 5");

        }

        //Paso 4
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //super.onPostExecute(bitmap);
            pd.dismiss();
            //Pintamos la imagen
            imageView.setImageBitmap(bitmap);
        }




    }
}
