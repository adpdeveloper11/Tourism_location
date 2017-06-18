package com.example.dell_3421.tourism_location;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Dell3421 on 6/16/2017.
 */

public class Check_location_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_check_location);
        getSupportActionBar().hide();

        // Set up the ViewPager with the sections adapter.
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent intent0 = new Intent(Check_location_Activity.this, MainActivity.class);
                        startActivity(intent0);
                        finish();
                        break;


                    case R.id.navigation_location:
                        Intent intent1 = new Intent(Check_location_Activity.this, Profile_Activity.class);
                        startActivity(intent1);
                        finish();
                        break;

                    case R.id.navigation_profile:
                        Intent intent2 = new Intent(Check_location_Activity.this, Profile_Activity.class);
                        startActivity(intent2);
                        finish();
                        break;
                }

                return false;
            }
        });



    }
}
