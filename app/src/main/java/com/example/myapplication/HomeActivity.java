package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class HomeActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        imageView=findViewById(R.id.category1);
        Glide.with(HomeActivity.this).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground)).load("").into(imageView);

        imageView=findViewById(R.id.category2);
        Glide.with(HomeActivity.this).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground)).load("").into(imageView);

        imageView=findViewById(R.id.category3);
        Glide.with(HomeActivity.this).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground)).load("").into(imageView);

        imageView=findViewById(R.id.category4);
        Glide.with(HomeActivity.this).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground)).load("").into(imageView);

        imageView=findViewById(R.id.category5);
        Glide.with(HomeActivity.this).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground)).load("").into(imageView);




    }
}
