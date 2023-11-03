package com.example.currency;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class MainActivity2 extends ArrayAdapter<String> {
    private final Activity context;
    private final int[] currencyImage;
    public MainActivity2(Activity context, int[] image, String[] shortCurrency, String[] longCurrency, String[] buy, String[] sell) {
        super(context, R.layout.activity_main2, shortCurrency);
        this.context = context;
        currencyImage = image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.activity_main2, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.flagImage);
        imageView.setImageResource(currencyImage[position]);

        return convertView;
    }
}
