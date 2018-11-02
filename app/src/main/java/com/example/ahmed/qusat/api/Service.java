package com.example.ahmed.qusat.api;

import com.example.ahmed.qusat.model.LoginResponse;
import com.example.ahmed.qusat.model.Profile;
import com.example.ahmed.qusat.model.ProfileData;
import com.example.ahmed.qusat.model.ProfileResponse;
import com.example.ahmed.qusat.model.RegisterResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Service {
    @POST("register")
    Call<RegisterResponse> register(@Body  Map<String,String> queryMab);

    @POST("login")
    Call<LoginResponse> login(@QueryMap Map<String ,  String> queryMap);

    @POST("profile-customer")
    Call<ProfileResponse> profileData (@Body Profile profile);
}
