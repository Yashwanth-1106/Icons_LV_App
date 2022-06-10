package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.widget.Toast;

public class MyService extends Service {


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int i;
        int fact = 1;
        int number = 5;
        for(i=1;i<=number;i++)
            fact=fact*i;
        Toast.makeText(this,"The Factorial of number "+number+ " is "+fact,Toast.LENGTH_LONG).show();
        return START_STICKY;

    }
}