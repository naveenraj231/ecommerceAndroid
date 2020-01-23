package com.example.myapplication.activity.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activity.App;
import com.example.myapplication.activity.adapter.CategoryItemAdapter;
import com.example.myapplication.activity.adapter.PopularProductsAdapter;
import com.example.myapplication.activity.interface1.Api;
import com.example.myapplication.activity.pojo.BaseResponse;
import com.example.myapplication.activity.pojo.CategoriesItem;
import com.example.myapplication.activity.pojo.Home;
import com.example.myapplication.activity.pojo.ProductsItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity implements PopularProductsAdapter.OnCardListener, CategoryItemAdapter.OnCategoryNameListener {

    private Retrofit retrofit;
    private Call<BaseResponse<Home>> call;
    private List<ProductsItem> list = new ArrayList();
    private List<CategoriesItem> categoriesList = new ArrayList();

    private TextView textView;

    private ImageView imageView;
    private RecyclerView recyclerView;
    private RecyclerView categoryRecyclerView;
    private CategoryItemAdapter categoryItemAdapter;
    private PopularProductsAdapter popularProductsAdapter;
    private Home home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initRecyclerView();
        initBottomNavigation();
        initRetrofitAndCallApi();
        apiCallback();
        //  fillMockHomeData();

        SharedPreferences sharedPreferences=getSharedPreferences("login_details", MODE_PRIVATE);SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("login", false);
        editor.commit();




    }


    private void initRecyclerView() {
        categoryRecyclerView = findViewById(R.id.recycler_view_categories);

        categoryItemAdapter = new CategoryItemAdapter(categoriesList, this);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoryRecyclerView.setAdapter(categoryItemAdapter);

        popularProductsAdapter = new PopularProductsAdapter(list, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(HomeActivity.this, 2);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(popularProductsAdapter);
    }

    private void initBottomNavigation() {
        //Initialising bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        //Set HOME selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //perform Item SELECTION LISTENER
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.dashboard:


                        SharedPreferences sharedPreferences=getSharedPreferences("user_details",MODE_PRIVATE);
                        Boolean value=sharedPreferences.getBoolean("login",false);
                        if(!value) {
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            overridePendingTransition(0, 0);
                            return true;
                        }
                        else if(value)
                        {
                            startActivity(new Intent(getApplicationContext(),DashBoardActivity.class));
                            overridePendingTransition(0,0);
                            return true;
                        }


                    case R.id.home:

                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(), CartActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }


                return false;
            }
        });
    }

    public void initRetrofitAndCallApi() {
        retrofit = App.getApp().getRetrofit();
        Api api = retrofit.create(Api.class);
        call = api.getProducts();
    }




    private void apiCallback() {

        call.enqueue(new Callback<BaseResponse<Home>>() {
            @Override
            public void onResponse(Call<BaseResponse<Home>> call, Response<BaseResponse<Home>> response)
            {
                if (response.isSuccessful())
                {
                    home = response.body().getData();
                    categoriesList.clear();
                    list.clear();
                    categoriesList.addAll(home.getCategories());
                    for(int i=0;i<home.getCategories().size();i++) {
                        list.addAll(home.getCategories().get(i).getProducts());
                    }
                    categoryItemAdapter.notifyDataSetChanged();
                    popularProductsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Home>> call, Throwable t) {
                Log.e("Check", t.getMessage());
            }
        });


    }

    @Override
    public void onCardClick(String id) {
        Toast.makeText(HomeActivity.this, id, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ProductDescriptionActivity.class);
        intent.putExtra("productId", id);
        startActivity(intent);

    }


    @Override
    public void onTextClick(String categoryId) {
        list.clear();
        for (int i=0;i<home.getCategories().size();i++)
        {
            if(home.getCategories().get(i).getId()==categoryId)
                list.addAll(home.getCategories().get(i).getProducts());
        }

        popularProductsAdapter.notifyDataSetChanged();


    }

//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        SharedPreferences sharedPreferences=getSharedPreferences("login_details", MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putBoolean("login", false);
//        editor.commit();
//
//
//    }
}
