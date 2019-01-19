package com.year.Day24hours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }



    public void onClickback(View view) {
        Intent intent = new Intent(LearnActivity.this, MyActivity.class);
        startActivity(intent);
    }
}
