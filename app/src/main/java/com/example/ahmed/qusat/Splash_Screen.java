package com.example.ahmed.qusat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahmed.qusat.Activites.First_Activity;
import com.example.ahmed.qusat.Activites.Second_Activity;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        Thread timer=new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intMainActivity=new Intent(Splash_Screen.this,Second_Activity.class);
                    startActivity(intMainActivity);
                    finish();
                }
            }
        };
        timer.start();

    }
}
