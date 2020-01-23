package com.example.myapplication.controller;

import com.example.myapplication.model.Customer;
import com.example.myapplication.model.CustomerDetails;
import com.example.myapplication.model.LoginRequestBody;
import com.example.myapplication.model.ProductDetails;
import com.example.myapplication.model.Signupbody;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    @POST("/customer/signin")
    Call<CustomerDetails> getCus(@Body LoginRequestBody requestBody);

    @POST("/customer/signup")
    Call<CustomerDetails> signup(@Body Signupbody signupBody);

    @GET("/product/details")
    Call<List<ProductDetails>> getprod();

    @GET("/user/dashboard/{id}")
    Call<List<Customer>> getCustomerdetails(@Path( "id") String string);

    @GET("/search/{text}")
    Call<List<ProductDetails>> getsearchlist(@Path("text") String string);


}
