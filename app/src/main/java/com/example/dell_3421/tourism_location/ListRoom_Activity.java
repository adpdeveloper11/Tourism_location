package com.example.dell_3421.tourism_location;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dell_3421.tourism_location.Room.CustomAdapter;
import com.google.android.gms.games.multiplayer.realtime.Room;


public class ListRoom_Activity extends AppCompatActivity {
    int[] resId = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};
    String[] list = {"Hotel\ntel.0111111111","Hotel\ntel.022222222","Hotel\ntel.033333333"};



    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_room);
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
                        Intent intent0= new Intent(ListRoom_Activity.this, Check_location_Activity.class);
                        startActivity(intent0);
                        finish();
                        break;


                    case R.id.navigation_location:
                        Intent intent1 = new Intent(ListRoom_Activity.this, Check_location_Activity.class);
                        startActivity(intent1);
                        finish();
                        break;

                    case R.id.navigation_profile:
                        Intent intent2 = new Intent(ListRoom_Activity.this, Profile_Activity.class);
                        startActivity(intent2);
                        finish();
                        break;
                }

                return false;
            }
        });


        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),list,resId);

        ListView listView = (ListView) findViewById(R.id.list1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            }
        });
    }
}
