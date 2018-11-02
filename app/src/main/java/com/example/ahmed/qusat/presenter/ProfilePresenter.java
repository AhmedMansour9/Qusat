package com.example.ahmed.qusat.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.ahmed.qusat.api.Client;
import com.example.ahmed.qusat.api.Service;
import com.example.ahmed.qusat.model.ProfileResponse;
import com.example.ahmed.qusat.view.ProfileView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter {
    Context context;
    ProfileView profileView;

    public ProfilePresenter(Context context, ProfileView profileView) {
        this.context = context;
        this.profileView = profileView;
    }
    public  void getProfileData(String user_token,String lan) {
        Map<String,String> map=new HashMap<>(  );
        map.put( "user_token",user_token );
        map.put( "lan",lan );
        Service service=Client.getClient().create( Service.class );
        Call<ProfileResponse> call=service.profileData( map );
        call.enqueue( new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                Toast.makeText( context, "sucess", Toast.LENGTH_LONG ).show();
                profileView.showProfileData(response.body().getData());

            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Toast.makeText( context, "failed", Toast.LENGTH_SHORT ).show();

            }
        } );

    }
}
