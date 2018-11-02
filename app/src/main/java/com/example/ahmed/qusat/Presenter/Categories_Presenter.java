package com.example.ahmed.qusat.Presenter;

import android.content.Context;

import com.example.ahmed.qusat.Model.Categories_Response;
import com.example.ahmed.qusat.Retrofit.ApiClint;
import com.example.ahmed.qusat.Retrofit.Apiinterface;
import com.example.ahmed.qusat.View.Categories_View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed on 30/10/2018.
 */

public class Categories_Presenter {


    Categories_View getCategories;

    public Categories_Presenter(Context context, Categories_View getCategories) {
        this.getCategories = getCategories;

    }

    public void GetCategories(String lang) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("lan", lang);
        queryMap.put("api_token", "100");
        Apiinterface apiInterface = ApiClint.getClient().create(Apiinterface.class);

        Call<Categories_Response> call = apiInterface.categories(queryMap);
        call.enqueue(new Callback<Categories_Response>() {
            @Override
            public void onResponse(Call<Categories_Response> call, Response<Categories_Response> response) {

                if (response.isSuccessful()) {
                    if (response.body().getData() != null) {
                        getCategories.Categories(response.body().getData());
                    } else {
                        getCategories.ErrorCategories();
                    }
                } else {
                    getCategories.ErrorCategories();
                }
            }

            @Override
            public void onFailure(Call<Categories_Response> call, Throwable t) {
                getCategories.ErrorCategories();

            }
        });
    }
}

