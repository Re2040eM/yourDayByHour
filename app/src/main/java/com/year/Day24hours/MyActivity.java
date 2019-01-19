package com.year.Day24hours;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;

import java.util.ArrayList;

public class MyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Log.d(TAG, "onCreate: Started CalendarActivity class");
        CalendarView mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                //log the date that was clicked
                String date = year + "/" + month + "/" + dayOfMonth;
                Log.d(TAG, "onSelectedDayChange: ClickedDate: " + date);

                Intent intent = new Intent(MyActivity.this, TableActivity.class);
                startActivity(intent);
            }

        });
    }

    public void onClickabout(View view){
        Intent intent = new Intent(MyActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_help) {
            Intent intent = new Intent(MyActivity.this, LearnActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList listActivity = db.get_All_Activity();
        ArrayList listURL = db.get_All_URL();
        ArrayList listPack = db.get_All_PackName();

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cal) {
            Intent intent = new Intent(MyActivity.this, MyActivity.class);
            startActivity(intent);}

        else if (id == R.id.nav_table) {
            Intent intent = new Intent(MyActivity.this, TableActivity.class);
            startActivity(intent);}

        else if (id == R.id.nav_share) {

            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String sAux = "\nأنصحك بتحميل هذا التطبيق\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=com.year.Day24hours \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));

            } catch(Exception e) {
                //e.toString();
            }
        }

        else if (id == R.id.nav_idea) {
            Intent intent = new Intent(MyActivity.this, ideaActivity.class);
            startActivity(intent);}

        else if (id == R.id.nav_learn) {
            Intent intent = new Intent(MyActivity.this, LearnActivity.class);
            startActivity(intent);}

        else if (id == R.id.nav_tg) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "com.year.Day24hours")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + "com.year.Day24hours")));
            }
        }

        else if (id == R.id.nav_about) {
            Intent intent = new Intent(MyActivity.this, AboutActivity.class);
            startActivity(intent);}

        else if (id == R.id.nav_help) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto: reem.naw@gmail.com")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "");
            intent.putExtra(Intent.EXTRA_SUBJECT, "مشاكل تواجهك في تطبيق يومك بالساعة");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        else if (id == R.id.nav_send) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto: reem.naw@gmail.com")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "");
            intent.putExtra(Intent.EXTRA_SUBJECT, "اقتراح لتطوير تطبيق يومك بالساعة");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        else if (id == R.id.nav_exit) {
            finishAffinity(); // اغلاق كافة التطبيق
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
