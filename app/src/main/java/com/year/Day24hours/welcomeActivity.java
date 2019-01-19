package com.year.Day24hours;
/**
import android.view.View;
import android.view.View;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class welcomeActivity extends DialogFragment implements View.OnClickListener {

    View view;
    Button butHome;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_welcome,container,false);
        butHome=(Button)view.findViewById(R.id.buthome);
        Thread thread = new Thread(){

            @Override
            public void run(){

                try {
                    sleep(6000);
                    Intent mySuperIntent = new Intent(getContext().getApplicationContext(), MyActivity.class);
                    startActivity(mySuperIntent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }; thread.start();
        butHome.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
    }
} */
