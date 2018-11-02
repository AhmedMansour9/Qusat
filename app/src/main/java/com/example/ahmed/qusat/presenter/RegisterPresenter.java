package com.example.ahmed.qusat.presenter;

import android.content.Context;

import com.example.ahmed.qusat.api.Client;
import com.example.ahmed.qusat.api.Service;
import com.example.ahmed.qusat.model.RegisterResponse;
import com.example.ahmed.qusat.model.User;
import com.example.ahmed.qusat.view.RegisterView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {
    RegisterView registerView;
    Context context;

    public RegisterPresenter(Context context, RegisterView registerView) {
        this.registerView = registerView;
        this.context = context;
    }

    public void register(User userRegister) {
        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put( "api_token",userRegister.getApi_token() );
        queryMap.put( "first_name", userRegister.getFirst_name() );
        queryMap.put( "last_name", userRegister.getLast_name() );
        queryMap.put( "email", userRegister.getEmail() );
        queryMap.put( "password", userRegister.getPassword() );
        queryMap.put( "username", "shimaarefaat" );
        queryMap.put( "ssn", userRegister.getSsn() );
        queryMap.put( "phone", userRegister.getPhone() );
        queryMap.put( "gender", userRegister.getGender() );
        queryMap.put( "address", userRegister.getAddress() );
        queryMap.put( "image",userRegister.getBase64() );

        Service service = Client.getClient().create( Service.class );

       Call<RegisterResponse> call = service.register(queryMap);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if (response.isSuccessful()) {
                        registerView.openMain();

                }else {
                    registerView.showError("");

                }
            }


            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                registerView.showError("error");

            }
        });
    }
}
