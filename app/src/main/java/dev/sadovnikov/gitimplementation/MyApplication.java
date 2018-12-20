package dev.sadovnikov.gitimplementation;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    HelloWrold helloWrold;

    public static MyApplication from(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        helloWrold = new HelloWrold();
    }

    public HelloWrold getHelloWrold() {
        return helloWrold;
    }
}
