package com.example.dell_3421.tourism_location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dell3421 on 6/18/2017.
 */

public class SplashActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    long delay_time;
    long time = 3000L;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);
        getSupportActionBar().hide();
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                Intent go  = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(go);
                finish();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        delay_time = time;

        handler.postDelayed(runnable,delay_time);
        time = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }
}
