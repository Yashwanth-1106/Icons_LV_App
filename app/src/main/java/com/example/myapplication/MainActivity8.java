package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity8<genAppsList> extends AppCompatActivity {
    String[] data = {"Gallery","Settings","Contacts","Music","Mail"};
    int[] imageid={R.drawable.ic_launcher_background};
    ListView lV;
    GridView g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        lV=(ListView) findViewById(R.id.lV);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,data);
        lV.setAdapter(adapter);

    }


}