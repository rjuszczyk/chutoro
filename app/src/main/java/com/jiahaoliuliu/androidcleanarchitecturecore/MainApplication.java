package com.jiahaoliuliu.androidcleanarchitecturecore;

import android.app.Application;

public class MainApplication extends Application {

    private static MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainComponent.builder().build();
    }

    public static MainComponent getMainComponent() {
        return mainComponent;
    }
}
