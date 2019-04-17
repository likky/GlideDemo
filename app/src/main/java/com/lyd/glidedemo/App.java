package com.lyd.glidedemo;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static App application;

    public static Context getMyApplicationContext() {
        return application.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
