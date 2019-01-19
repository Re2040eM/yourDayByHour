package com.year.Day24hours;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Started CalendarActivity class");
        CalendarView mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                //log the date that was clicked
                String date = year + "/" + month + "/" + dayOfMonth;
                Log.d(TAG, "onSelectedDayChange: ClickedDate: " + date);

                Intent intent = new Intent(MainActivity.this, TableActivity.class);
                startActivity(intent);
            }

        });
    }
    public void onClickabout(View view){
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }


}
