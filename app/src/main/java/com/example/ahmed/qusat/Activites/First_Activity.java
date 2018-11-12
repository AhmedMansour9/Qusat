package com.example.ahmed.qusat.Activites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ahmedd.qusat.R;
import com.example.ahmed.qusat.Fragments.Guest_Fragment;

import java.util.Locale;

public class First_Activity extends AppCompatActivity {
    SharedPreferences sha;
    SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shared=getSharedPreferences("Language",MODE_PRIVATE);
        String Lan=shared.getString("Lann",null);
        if(Lan!=null) {
            Locale locale = new Locale(Lan);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
        setContentView(R.layout.activity_main);
        sha=getSharedPreferences("login",MODE_PRIVATE);
        String logi=sha.getString("logggin",null);
        if(logi!=null){
            startActivity(new Intent(First_Activity.this,Second_Activity.class));
            finish();
        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent,new Guest_Fragment()).commit();
        }

    }
}
