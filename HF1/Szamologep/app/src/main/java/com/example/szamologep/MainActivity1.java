package com.example.szamologep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {

    Button buttonosszead, buttonkivon, buttonszoroz, buttonoszt;
    EditText szam1, szam2;
    TextView eredmeny;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        buttonosszead = findViewById(R.id.osszead);
        buttonkivon = findViewById(R.id.kivon);
        buttonszoroz = findViewById(R.id.szorzas);
        buttonoszt = findViewById(R.id.osztas);
        szam1 = findViewById(R.id.number1);
        szam2 = findViewById(R.id.number2);
        eredmeny = findViewById(R.id.eredmeny);

        buttonosszead.setOnClickListener(this);
        buttonkivon.setOnClickListener(this);
        buttonszoroz.setOnClickListener(this);
        buttonoszt.setOnClickListener(this);
    }

    public int getSzamEditText(EditText editText){
        if(editText.getText().toString().equals("")){
            Toast.makeText(this,"Enter number",Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View view) {
        num1 = getSzamEditText(szam1);
        num2 = getSzamEditText(szam2);

        if (view.getId() == R.id.osszead) {
            eredmeny.setText(" = " + (num1 + num2));
        } else if (view.getId() == R.id.kivon) {
            eredmeny.setText(" = " + (num1 - num2));
        } else if (view.getId() == R.id.szorzas) {
            eredmeny.setText(" = " + (num1 * num2));
        } else if (view.getId() == R.id.osztas) {
            if (num2 != 0) {
                eredmeny.setText(" = " + ((float) num1 / (float) num2));
            } else {
                eredmeny.setText(" = Hiba: nullával osztás!");
            }
        }
    }

}
