package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("Status", "MainActivity2:onCreate");

        Button start2 = findViewById (R.id.button2);
        Button start3 = findViewById (R.id.button3);
        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        start3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Status", "MainActivity2:onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Status", "MainActivity2:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status", "MainActivity2:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Status", "MainActivity2:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status", "MainActivity2:onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status", "MainActivity2:onDestroy");
    }

}