package dev.sadovnikov.gitimplementation;

import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication myApplication = new MyApplication();
        HelloWrold helloWrold = MyApplication.from(this).getHelloWrold();
        Log.d(TAG, "onCreate: " + helloWrold.secret);

        // Изменения, после которых проект можно релизить в мастер
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void getSecret() {
        HelloWrold helloWrold = new HelloWrold();
        Field field = null;
        try {
            field = helloWrold.getClass().getDeclaredField("secret");
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "getSecret: ", e);
        }
        Object o = null;
        try {
            o = field.get(helloWrold);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "getSecret: ", e);
        }
        Log.d(TAG, "getSecret: " + o);
    }
}
