package com.example.tablelayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText codeText = findViewById(R.id.code);
        EditText nameText = findViewById(R.id.name);
        EditText priceText = findViewById(R.id.price);
        Button add = findViewById(R.id.AddButton);
        Button cancel = findViewById(R.id.CancelButton);
        Button show = findViewById(R.id.ViewButton);
        TextView showText = findViewById(R.id.ListResult);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = codeText.getText().toString();
                String name = nameText.getText().toString();
                String price = priceText.getText().toString();

                Product product = new Product(code,name,price);
                productList.add(product);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codeText.setText("");
                nameText.setText("");
                priceText.setText("");
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder builder = new StringBuilder();
                for (Product product : productList) {
                    builder.append("Product code: ").append(product.getCode()).append("\n");
                    builder.append("Product name: ").append(product.getName()).append("\n");
                    builder.append("Product price: ").append(product.getPrice()).append("\n\n");
                }
                showText.setText(builder.toString());
            }
        });

    }
}