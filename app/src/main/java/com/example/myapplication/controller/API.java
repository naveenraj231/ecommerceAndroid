package com.example.myapplication.controller;

import android.app.Application;

import com.facebook.FacebookSdk;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API extends Application {
    private static Retrofit retrofitClient;

    public static String BASE_URL = "http://10.177.68.47:8089";

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.setApplicationId("499064640741937");
        FacebookSdk.sdkInitialize(getApplicationContext());

    }

    private static Retrofit initializeRetrofit(String baseUrl) {
        OkHttpClient client= new OkHttpClient.Builder().build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(client)
                .build();
    }

    public static Retrofit getRetrofitClient(String baseUrl) {
        if (retrofitClient == null) {
            retrofitClient = initializeRetrofit(baseUrl);
        }
        return retrofitClient;
    }

    public static Retrofit getProductRetrofit(String baseUrl) {
        if (retrofitClient == null) {
            retrofitClient = initializeRetrofit(baseUrl);
        }
        return retrofitClient;
    }
}
