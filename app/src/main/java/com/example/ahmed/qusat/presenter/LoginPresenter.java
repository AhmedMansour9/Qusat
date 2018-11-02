package com.example.ahmed.qusat.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.ahmed.qusat.R;
import com.example.ahmed.qusat.api.Client;
import com.example.ahmed.qusat.api.Service;
import com.example.ahmed.qusat.model.LoginResponse;
import com.example.ahmed.qusat.model.User;
import com.example.ahmed.qusat.view.LoginView;
import com.example.ahmed.qusat.view.RegisterView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    Context context;
    LoginView loginView;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;
    }
    public void Login(String email,String password)
    {
        Map<String,String> map=new HashMap<>(  );
        map.put( "email", email);
        map.put( "password",password );
        map.put( "api_token","100" );

        Service service= Client.getClient().create( Service.class );
        Call<LoginResponse> call=service.login( map );
       call.enqueue( new Callback<LoginResponse>() {
           @Override
           public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
               if(response.isSuccessful())
               {
                   if(response.body().getData().getMessage().equals( "Waiting Your Confirm" )) {
                  loginView.WaitingEmail();
                   }else if(response.body().getData().getMessage().equals( "success" )){
                       //Toast.makeText( context, "sucessss", Toast.LENGTH_LONG ).show();

                       loginView.OpenMain( response.body().getData().getUserToken() );
                   }
                   }
                   else {
                   loginView.ErrorMessage();

               }

               }


           @Override
           public void onFailure(Call<LoginResponse> call, Throwable t) {
               loginView.ErrorMessage();
           }
       } );
    }
}


