package com.example.mobilesensingapp;

import android.app.Application;
import android.content.Context;

public class ApplicationContext extends Application {
    public static Context context;

    public ApplicationContext() {
        this.context=this;
    }

    public static Context getContext() {
        return context;
    }
}
