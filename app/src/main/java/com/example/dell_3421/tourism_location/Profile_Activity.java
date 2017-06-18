package com.example.dell_3421.tourism_location;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

/**
 * Created by Dell3421 on 6/16/2017.
 */

public class Profile_Activity extends AppCompatActivity{
    private LocalActivityManager mlocalActivityManager;

    private TabHost tabHost;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profile);
        setTitle("Profile");
        getSupportActionBar().hide();
        Button btnGosimplelogin = (Button) findViewById(R.id.button3);
        btnGosimplelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Profile_Activity.this,MainLogin_Activity.class);
                startActivity(go);
            }
        });

        mlocalActivityManager = new LocalActivityManager(this,false);
        mlocalActivityManager.dispatchCreate(savedInstanceState);

        tabHost = (TabHost) findViewById(R.id.tab_host1);
        tabHost.setup(mlocalActivityManager);
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");

        tabSpec1.setIndicator("แก้ไขข้อมูลส่วนตัว");
        tabSpec1.setContent(new Intent(this,Tab_Edit_Profile.class));

        tabSpec2.setIndicator("หมุดของฉัน");
        tabSpec2.setContent(new Intent(this,Tab_Sticky.class));

        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);


        // Set up the ViewPager with the sections adapter.
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent intent0 = new Intent(Profile_Activity.this, MainActivity.class);
                        startActivity(intent0);
                        finish();
                        break;


                    case R.id.navigation_location:
                        Intent intent2 = new Intent(Profile_Activity.this, Check_location_Activity.class);
                        startActivity(intent2);
                        finish();
                        break;


                    case R.id.navigation_profile:

                        break;

                }

                return false;
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mlocalActivityManager.dispatchPause(!isFinishing());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mlocalActivityManager.dispatchResume();

    }
}
