package com.example.myapplication.activity.interface1;


import com.example.myapplication.activity.pojo.BaseResponse;
import com.example.myapplication.activity.pojo.CartItem;
import com.example.myapplication.activity.pojo.Home;
import com.example.myapplication.activity.pojo.ProductDescription;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "http://10.177.68.47:8089";

    @GET("/home")
    Call<BaseResponse<Home>> getProducts();


    @GET("/category/product/{categoryid}")
    Call<BaseResponse<Home>> getCategoryProducts(@Path("categoryid") String categoryId);


   @GET("/product/description/{id}")
    Call<BaseResponse<ProductDescription>> getProductDescription(@Path("id") String productId);

   @GET
    Call<BaseResponse<CartItem>> getCartItems();



//    @GET("/user/details")
//    Call<>

// @GET("cart/count")
//Call<List<PopularProducts>> getPopularProducts;
//

}
