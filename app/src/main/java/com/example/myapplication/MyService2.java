package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService2 extends Service {
    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String ed1 = intent.getExtras().getString("username");
        String ed2 = intent.getExtras().getString("passsword");
        Intent next = new Intent(getApplicationContext(),MainActivity4.class);
        next.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(next);
        return START_STICKY;
    }
}


