package com.example.myapplication.activity;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.myapplication.activity.interface1.Api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static Retrofit retrofit;
    private static App app;


    @Override
    public void onCreate() {
        super.onCreate();
        setApp(this);
    }

    public  Retrofit getRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build();

        return retrofit;
    }

    public static App getApp() {
        return app;
    }

    public static void setApp(App app) {
        App.app = app;
    }


}
