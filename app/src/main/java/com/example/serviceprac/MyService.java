package com.example.serviceprac;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {
    Thread thread;
    public MyService() {
    }

    class CustomBinder extends Binder {
        public CustomBinder(){

        }

        public MyService getservice(){
            return MyService.this;
        }
    }

    IBinder binder = new CustomBinder();

    @Override
    public void onCreate() {

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        thread = new Thread(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                while(true) {
                    i++;
                    Log.d("count", i + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        thread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("onDestry", "onDestroy()");
        if(thread!=null){
            thread.interrupt();
            thread = null;

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
