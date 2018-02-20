package com.mrdiaz.apigoogleplacesproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.mrdiaz.apigoogleplacesproject.R;

public class MainActivity extends AppCompatActivity {


    DelayAutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        autoCompleteTextView.setAdapter(new CityAutoCompleteAdapter(MainActivity.this));


    }
}
