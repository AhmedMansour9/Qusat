package com.example.ahmed.qusat.Presenter;

import android.content.Context;

import com.example.ahmed.qusat.Model.Banners_Response;
import com.example.ahmed.qusat.Model.Leons;
import com.example.ahmed.qusat.Model.Leons_Response;
import com.example.ahmed.qusat.Retrofit.ApiClint;
import com.example.ahmed.qusat.Retrofit.Apiinterface;
import com.example.ahmed.qusat.View.Banners_View;
import com.example.ahmed.qusat.View.Leons_View;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed on 01/11/2018.
 */

public class Leons_Presenter {

    Leons_View getLeons;

    public Leons_Presenter(Context context, Leons_View getLeons) {
        this.getLeons = getLeons;

    }

    public void GetLeons(String lang,String id) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("lan", lang);
        queryMap.put("api_token", "100");
        queryMap.put("product_id", id);
        Apiinterface apiInterface = ApiClint.getClient().create(Apiinterface.class);

        Call<Leons_Response> call = apiInterface.Leons(queryMap);
        call.enqueue(new Callback<Leons_Response>() {
            @Override
            public void onResponse(Call<Leons_Response> call, Response<Leons_Response> response) {

                if (response.isSuccessful()) {
                    if (response.body().getData() != null) {
                        getLeons.Leons(response.body().getData());
                    } else {
                        getLeons.Error();
                    }
                } else {
                    getLeons.Error();
                }
            }

            @Override
            public void onFailure(Call<Leons_Response> call, Throwable t) {
                getLeons.Error();

            }
        });
    }
}
