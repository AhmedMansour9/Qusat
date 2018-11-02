package com.example.ahmed.qusat.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahmed.qusat.Fragments.Guest_Fragment;
import com.example.ahmed.qusat.Fragments.Home;
import com.example.ahmed.qusat.R;

public class Second_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportFragmentManager().beginTransaction().replace(R.id.flContenttwo,new Home()).commit();
    }
}
