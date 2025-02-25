package com.example.donation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button donateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        donateButton = (Button) findViewById(R.id.donateButton);

        if (donateButton != null) {
            android.util.Log.v("Donate", "Really got the donate button");
        }
    }

    public void donateButtonPressed(View view) {
        Log.v("Donate", "Donate pressed!");
    }
}

