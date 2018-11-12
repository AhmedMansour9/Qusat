package com.example.ahmed.qusat.Retrofit;

import com.example.ahmed.qusat.Model.Approved_Response;
import com.example.ahmed.qusat.Model.Banners_Response;
import com.example.ahmed.qusat.Model.Categories_Response;
import com.example.ahmed.qusat.Model.Leons_Response;
import com.example.ahmed.qusat.Model.LoginResponse;
import com.example.ahmed.qusat.Model.MyLoans_Response;
import com.example.ahmed.qusat.Model.Order_loan_Response;
import com.example.ahmed.qusat.Model.Pending_Response;
import com.example.ahmed.qusat.Model.Products_Response;
import com.example.ahmed.qusat.Model.ProfileResponse;
import com.example.ahmed.qusat.Model.RegisterResponse;
import com.example.ahmed.qusat.Model.Spinner_Loan_Response;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Ahmed on 30/10/2018.
 */

public interface Apiinterface {

    @POST("category")
    Call<Categories_Response> categories(@QueryMap Map<String, String> queryMab);

    @POST("banner")
    Call<Banners_Response> banners(@Body Map<String, String> queryMab);

    @POST("product")
    Call<Products_Response> Products(@QueryMap Map<String, String> queryMab);

    @POST("featureProduct")
    Call<Products_Response> ProductsFeature(@QueryMap Map<String, String> queryMab);


    @POST("loan-product-details")
    Call<Leons_Response> Leons(@QueryMap Map<String, String> queryMab);
    @POST("register")
    Call<RegisterResponse> register(@Body Map<String,String> queryMab);

    @POST("login")
    Call<LoginResponse> login(@QueryMap Map<String ,  String> queryMap);

    @POST("profile-customer")
    Call<ProfileResponse> profileData (@QueryMap Map <String,String> queryMap);

    @POST("loan-product")
    Call<Spinner_Loan_Response> SpinnerLoan (@QueryMap Map <String,String> queryMap);
    @POST("add-order")
    Call<Order_loan_Response> OrderLoan (@QueryMap Map <String,String> queryMap);
    @POST("get-order")
    Call<Pending_Response> Pending (@QueryMap Map <String,String> queryMap);
    @POST("get-loan")
    Call<Approved_Response> Approved (@QueryMap Map <String,String> queryMap);

    @POST("get-payment")
    Call<MyLoans_Response> MyLeons (@QueryMap Map <String,String> queryMap);


}
