package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d("Status", "MainActivity3:onCreate");

        Button start5 = findViewById (R.id.button5);
        Button start4 = findViewById (R.id.button4);
        start5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        start4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Status", "MainActivity3:onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Status", "MainActivity3:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status", "MainActivity3:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Status", "MainActivity3:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status", "MainActivity3:onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status", "MainActivity3:onDestroy");
    }

}