package com.zhi.www.myservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    Button mBtnStartService;
    Button mBtnStopService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnStartService = (Button) findViewById(R.id.btn_start_service);
        mBtnStopService = (Button) findViewById(R.id.btn_stop_service);
        mBtnStartService.setOnClickListener(this);
        mBtnStopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                getStartService();
                break;
            case R.id.btn_stop_service:
                getStopService();
                break;
        }
    }

    private void getStartService(){
        Intent intent = new Intent(MainActivity.this, MyService.class);
        intent.putExtra(MyService.TYPE, MyService.TYPE_START);
        startService(intent);
    }

    private void getStopService(){
        Intent intent = new Intent(MainActivity.this, MyService.class);
        intent.putExtra(MyService.TYPE, MyService.TYPE_STOP);
        startService(intent);
    }
}
