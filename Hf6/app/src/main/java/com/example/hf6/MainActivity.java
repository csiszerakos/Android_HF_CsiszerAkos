package com.example.hf6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BlankFragment1 fragment1 = new BlankFragment1();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment1)
                .commit();
        }
    }