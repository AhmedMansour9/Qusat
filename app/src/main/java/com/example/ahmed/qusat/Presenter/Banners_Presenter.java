package com.example.ahmed.qusat.Presenter;

import android.content.Context;

import com.example.ahmed.qusat.Model.Banners_Response;
import com.example.ahmed.qusat.Model.Categories_Response;
import com.example.ahmed.qusat.Retrofit.ApiClint;
import com.example.ahmed.qusat.Retrofit.Apiinterface;
import com.example.ahmed.qusat.View.Banners_View;
import com.example.ahmed.qusat.View.Categories_View;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed on 31/10/2018.
 */

public class Banners_Presenter {

    Banners_View getCategories;

    public Banners_Presenter(Context context, Banners_View getCategories) {
        this.getCategories = getCategories;

    }

    public void GetBanners(String lang) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("lan", lang);
        queryMap.put("api_token", "100");
        Apiinterface apiInterface = ApiClint.getClient().create(Apiinterface.class);

        Call<Banners_Response> call = apiInterface.banners(queryMap);
        call.enqueue(new Callback<Banners_Response>() {
            @Override
            public void onResponse(Call<Banners_Response> call, Response<Banners_Response> response) {

                if (response.isSuccessful()) {
                    if (response.body().getData() != null) {
                        getCategories.banners(response.body().getData());
                    } else {
                        getCategories.ErrorPanner();
                    }
                } else {
                    getCategories.ErrorPanner();
                }
            }

            @Override
            public void onFailure(Call<Banners_Response> call, Throwable t) {
                getCategories.ErrorPanner();

            }
        });
    }
}