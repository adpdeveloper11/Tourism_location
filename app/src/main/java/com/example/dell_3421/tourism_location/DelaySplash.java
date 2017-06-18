package com.example.dell_3421.tourism_location;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by Dell3421 on 6/18/2017.
 */

public class DelaySplash extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(2000);
    }
}
