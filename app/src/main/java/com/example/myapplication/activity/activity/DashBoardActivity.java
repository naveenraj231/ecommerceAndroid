package com.example.myapplication.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {








        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //Initialising bottom navigation
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);


        //Set HOME selected
        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        //perform Item SELECTION LISTENER
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.dashboard:

                        return true;

                    case R.id.home:

                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(  0,0);

                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(),CartActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }



                return false;
            }
        });


    }
}
