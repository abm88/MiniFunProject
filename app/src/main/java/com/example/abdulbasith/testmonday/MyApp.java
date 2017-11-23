package com.example.abdulbasith.testmonday;

import android.app.Application;
import android.content.Context;

import com.example.abdulbasith.testmonday.data.component.IApplicationComponent;

/**
 * Created by Abdul Basith on 20/11/2017.
 */

public class MyApp extends Application{
    public static Application sApplication;
    IApplicationComponent iApplicationComponent;

    public IApplicationComponent getiApplicationComponent() {
        return iApplicationComponent;
    }

    public static Application getsApplication() {
        return sApplication;
    }

    public static Context getContext(){
        return getsApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
