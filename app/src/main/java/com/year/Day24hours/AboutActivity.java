package com.year.Day24hours;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        this.setTitle("من نحن");
    }

    public void onclickTw(View view) {

        Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Re2040eM?lang=ar"));
        this.startActivity(website);

    }

        public void onClickback(View view) {
        Intent intent = new Intent(AboutActivity.this, MyActivity.class);
        startActivity(intent);

    }
}
