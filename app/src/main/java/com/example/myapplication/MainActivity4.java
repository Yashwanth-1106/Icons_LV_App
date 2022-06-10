package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity4<ed3> extends AppCompatActivity {
    public TextView ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ed3=findViewById(R.id.Text3);
        ed3.setText("You have logged in successfully !");

    }

}