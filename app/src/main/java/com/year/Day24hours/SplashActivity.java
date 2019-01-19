package com.year.Day24hours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME = 10000; //This is 4 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(){

            @Override
            public void run(){

                try {
                    sleep(6000);
                    Intent mySuperIntent = new Intent(getApplicationContext(), MyActivity.class);
                    startActivity(mySuperIntent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }; thread.start();
    }

    public void onClickback(View view) {
        Intent intent = new Intent(SplashActivity.this, MyActivity.class);
        startActivity(intent);
    }
}


