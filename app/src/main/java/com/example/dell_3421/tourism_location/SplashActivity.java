package com.example.dell_3421.tourism_location;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dell3421 on 6/18/2017.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);
        getSupportActionBar().hide();
        Intent go  = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(go);
        finish();
    }
}
