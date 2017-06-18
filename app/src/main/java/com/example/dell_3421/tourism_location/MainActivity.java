package com.example.dell_3421.tourism_location;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main");
        getSupportActionBar().hide();

        // Set up the ViewPager with the sections adapter.
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:

                        break;

                    case R.id.navigation_location:
                        Intent intent1 = new Intent(MainActivity.this, Check_location_Activity.class);
                        startActivity(intent1);
                        finish();
                        break;

                    case R.id.navigation_profile:
                        Intent intent2 = new Intent(MainActivity.this, Profile_Activity.class);
                        startActivity(intent2);
                        finish();
                        break;
                }

                return false;
            }
        });


    }

}
