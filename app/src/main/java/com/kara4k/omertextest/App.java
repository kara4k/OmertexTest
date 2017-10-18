package com.kara4k.omertextest;


import android.app.Application;

import com.kara4k.omertextest.di.AppComponent;
import com.kara4k.omertextest.di.DaggerAppComponent;
import com.kara4k.omertextest.di.modules.AppModule;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
