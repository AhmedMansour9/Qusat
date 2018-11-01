package com.example.ahmed.qusat.Activites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahmed.qusat.Fragments.Guest_Fragment;
import com.example.ahmed.qusat.Fragments.Home;
import com.example.ahmed.qusat.R;

public class First_Activity extends AppCompatActivity {
    SharedPreferences sha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sha=getSharedPreferences("login",MODE_PRIVATE);
        String logi=sha.getString("logggin",null);
        if(logi !=null)
        {
            getSupportFragmentManager().beginTransaction().replace( R.id.flContent,new Home() ).commit();

        }

       else {
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent,new Guest_Fragment()).commit();
        }

    }
}
