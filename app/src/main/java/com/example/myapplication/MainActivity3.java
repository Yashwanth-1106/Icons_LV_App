package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    public EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ed1=findViewById(R.id.Text1);
        ed2=findViewById(R.id.Text2);
    }

    public void validation(View view){
        Intent intent = new Intent(this, MyService2.class);
        intent.putExtra("username", ed1.getText().toString());
        intent.putExtra("password", ed2.getText().toString());
        startService(intent);

    }

}