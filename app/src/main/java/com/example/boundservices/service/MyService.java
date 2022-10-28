package com.example.boundservices.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "RunningService";
    public final Binder binder = new ServiceBinder();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onUnbind: ");
    }

    public class ServiceBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    public String serveValue() {
        return "From the Service!";
    }
}