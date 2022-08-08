package com.example.sharedpreferences_sample;

import android.app.Application;

import com.example.sharedpreferences_sample.data_local.DataLocalManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
    }
}
