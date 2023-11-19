package com.example.contextmenu;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView animals;
    ArrayAdapter<String> adapter;
    ArrayList<String> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animals = findViewById(R.id.colorList);
        listItems.addAll(Arrays.asList(getResources().getStringArray(R.array.animals)));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        animals.setAdapter(adapter);
        registerForContextMenu(animals);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        int id = item.getItemId();

        if (animals != null && position >= 0 && position < animals.getChildCount()) {
            View childView = animals.getChildAt(position);
            if (childView instanceof TextView) {
                TextView textView = (TextView) childView;

                if (id == R.id.sarga) {
                    textView.setTextColor(Color.YELLOW);
                } else if (id == R.id.zold) {
                    textView.setTextColor(Color.GREEN);
                } else if (id == R.id.piros) {
                    textView.setTextColor(Color.RED);
                }
            }
        }

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();

        if (id == R.id.sort){
            Collections.sort(listItems );
            adapter.notifyDataSetChanged();
        }else if(id == R.id.delete){
            adapter.clear();
        }
        return true;
    }

}