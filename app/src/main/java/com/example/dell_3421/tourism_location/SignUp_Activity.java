package com.example.dell_3421.tourism_location;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dell-3421 on 6/10/2017.
 */

public class SignUp_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);
        setTitle("SIGN UP");
        getSupportActionBar().hide();

    }
}
