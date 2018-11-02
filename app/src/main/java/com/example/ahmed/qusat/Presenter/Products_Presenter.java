package com.example.ahmed.qusat.Presenter;

import android.content.Context;

import com.example.ahmed.qusat.Adapter.Products_Adapter;
import com.example.ahmed.qusat.Model.Categories_Response;
import com.example.ahmed.qusat.Model.Products_Response;
import com.example.ahmed.qusat.Retrofit.ApiClint;
import com.example.ahmed.qusat.Retrofit.Apiinterface;
import com.example.ahmed.qusat.View.Categories_View;
import com.example.ahmed.qusat.View.Products_View;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed on 31/10/2018.
 */

public class Products_Presenter {

    Products_View getProducts;

    public Products_Presenter(Context context, Products_View getCategories) {
        this.getProducts = getCategories;

    }

    public void Getbanners(String lang,String id) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("lan", lang);
        queryMap.put("category_id", id);
        queryMap.put("api_token", "100");
        Apiinterface apiInterface = ApiClint.getClient().create(Apiinterface.class);

        Call<Products_Response> call = apiInterface.Products(queryMap);
        call.enqueue(new Callback<Products_Response>() {
            @Override
            public void onResponse(Call<Products_Response> call, Response<Products_Response> response) {

                if (response.isSuccessful()) {
                    if (response.body().getData() != null) {
                        getProducts.Products(response.body().getData());
                    } else {
                        getProducts.ErrorProducts();
                    }
                } else {
                    getProducts.ErrorProducts();
                }
            }

            @Override
            public void onFailure(Call<Products_Response> call, Throwable t) {
                getProducts.ErrorProducts();

            }
        });
    }
}


