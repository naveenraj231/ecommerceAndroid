package com.example.myapplication.loginsignupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {

    ImageView imageView;
    Button signout;

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

        signout=(Button)findViewById(R.id.logout);

//        signout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LoginActivity loginActivity=new LoginActivity();
//                loginActivity.signout();
//            }
//        });







    }
}
