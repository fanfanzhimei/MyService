package com.zhi.www.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/1.
 */
public class MyService extends Service {
    private static final String TYPE_START_SERVICE = "服务已启动";
    private static final String TYPE_STOP_SERVICE = "服务已停止";

    public static final String TYPE = "type";
    public static final int TYPE_START = 0x1;
    public static final int TYPE_STOP = 0x2;

    @Override
    public void onCreate() {
        Log.e("onCreate:", "onCreate()");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("onStartCommand:", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.e("onStart:", "onStart()");
        String text = "";
        int type = intent.getIntExtra(TYPE, 0);
        if (TYPE_START == type) {
            text = TYPE_START_SERVICE;
        }
        if (TYPE_STOP == type) {
            text = TYPE_STOP_SERVICE;
        }
        Toast.makeText(MyApplication.getContext(), text, Toast.LENGTH_SHORT).show();
        super.onStart(intent, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
