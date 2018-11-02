package com.example.ahmed.qusat.Retrofit;

import com.example.ahmed.qusat.Model.Banners_Response;
import com.example.ahmed.qusat.Model.Categories_Response;
import com.example.ahmed.qusat.Model.Leons_Response;
import com.example.ahmed.qusat.Model.Products_Response;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Ahmed on 30/10/2018.
 */

public interface Apiinterface {

    @POST("category")
    Call<Categories_Response> categories(@QueryMap Map<String, String> queryMab);

    @POST("banner")
    Call<Banners_Response> banners(@QueryMap Map<String, String> queryMab);

    @POST("product")
    Call<Products_Response> Products(@QueryMap Map<String, String> queryMab);

    @POST("loan-product-details")
    Call<Leons_Response> Leons(@QueryMap Map<String, String> queryMab);

}
