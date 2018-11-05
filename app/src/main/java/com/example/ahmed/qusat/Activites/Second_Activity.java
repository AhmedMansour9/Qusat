package com.example.ahmed.qusat.Activites;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahmed.qusat.Fragments.Guest_Fragment;
import com.example.ahmed.qusat.Fragments.Home;
import com.example.ahmed.qusat.R;

import java.util.Locale;

public class Second_Activity extends AppCompatActivity {
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
        setContentView(R.layout.activity_main2);

        getSupportFragmentManager().beginTransaction().replace(R.id.flContenttwo,new Home()).commit();
    }
}
