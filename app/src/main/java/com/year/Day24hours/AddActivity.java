package com.year.Day24hours;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AddActivity extends AppCompatActivity {
    private static final String TAG = "AddActivity";

    DatabaseHelper db = new DatabaseHelper(this);
    ListView listViewact;
    ListView listViewpackage;
    ListView listViewurl;

    EditText etactivity;
    String packageName;
    EditText eturl;

    ArrayList listActivity;
    ArrayList listPack;
    ArrayList listURL;

    String idst;
    String eturlst;
    int id;
    int time;
    String butText;
    Date date = new Date();
    SimpleDateFormat myformat = new SimpleDateFormat("H");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.setTitle("معلومات النشاط");
        Intent intentBut = getIntent();
        butText = intentBut.getStringExtra("BUT_TEXT");
        Log.d(TAG, "App Label: " + butText);

        Log.e("DATE : ",myformat.format(date));


        etactivity = (EditText) findViewById(R.id.activity);
        eturl = (EditText) findViewById(R.id.url);

        listViewact = (ListView) findViewById(R.id.listviewact);
        listViewpackage = (ListView) findViewById(R.id.listviewpackage);
        listViewurl = (ListView) findViewById(R.id.listviewurl);

        File database = getApplicationContext().getDatabasePath(db.DbName);
        if (false == database.exists()) {
            db.getReadableDatabase();
            if (copyDatabase(this)) {
            }
            else {
            }
        }

        listActivity = db.get_All_Activity();
        ArrayAdapter arrayAdapteract = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listActivity);
        listViewact.setAdapter(arrayAdapteract);

        listURL = db.get_All_URL();
        ArrayAdapter arrayAdapterurl = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listURL);
        listViewurl.setAdapter(arrayAdapterurl);

        listPack = db.get_All_PackName();
        ArrayAdapter arrayAdapterpack = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listPack);
        listViewpackage.setAdapter(arrayAdapterpack);

        switch (butText){

            case "0":
                time = 24;
                idst = "0";
                id = 0;
                inputData();
                break;


            case "1":
                time = 1;
                idst = "1";
                id = 1;
                inputData();
                break;

            case "2":
                time = 2;
                idst = "2";
                id = 2;
                inputData();
                break;

            case "3":
                time = 3;
                idst = "3";
                id = 3;
                inputData();
                break;


            case "4":
                time = 4;
                idst = "4";
                id = 4;
                inputData();
                break;

            case "5":
                time = 5;
                idst = "5";
                id = 5;
                inputData();
                break;

            case "6":
                time = 6;
                idst = "6";
                id = 6;
                inputData();
                break;

            case "7":
                time = 7;
                idst = "7";
                id = 7;
                inputData();
                break;

            case "8":
                time = 8;
                idst = "8";
                id = 8;
                inputData();
                break;

            case "9":
                time = 9;
                idst = "9";
                id = 9;
                inputData();
                break;

            case "10":
                time = 10;
                idst = "10";
                id = 10;
                inputData();
                break;

            case "11":
                time = 11;
                idst = "11";
                id = 11;
                inputData();
                break;

            case "12":
                time = 12;
                idst = "12";
                id = 12;
                inputData();
                break;

            case "13":
                time = 13;
                idst = "13";
                id = 13;
                inputData();
                break;

            case "14":
                time = 14;
                idst = "14";
                id = 14;
                inputData();
                break;

            case "15":
                time = 15;
                idst = "15";
                id = 15;
                inputData();
                break;

            case "16":
                time = 16;
                idst = "16";
                id = 16;
                inputData();
                break;

            case "17":
                time = 17;
                idst = "17";
                id = 17;
                inputData();
                break;

            case "18":
                time = 18;
                idst = "18";
                id = 18;
                inputData();
                break;

            case "19":
                time = 19;
                idst = "19";
                id = 19;
                inputData();
                break;

            case "20":
                time = 20;
                idst = "20";
                id = 20;
                inputData();
                break;

            case "21":
                time = 21;
                idst = "21";
                id = 21;
                inputData();
                break;

            case "22":
                time = 22;
                idst = "22";
                id = 22;
                inputData();
                break;

            case "23":
                time = 23;
                idst = "23";
                id = 23;
                inputData();
                break;

            default:
                inputData();
        }
    }

    public void onClickChooseApp(View view) {
        Intent intent = new Intent(AddActivity.this, ChooseAppActivity.class);
        intent.putExtra("BUT_TEXT", butText);
        startActivity(intent);
        db.updateData(idst,etactivity.getText().toString(),packageName,eturl.getText().toString());

    }

    public void busave(View view) {
        if(etactivity.getText().toString().equals("")) {
            Toast.makeText(AddActivity.this, "الرجاء كتابة اسم النشاط", Toast.LENGTH_LONG).show();
        }
        else{
            Log.d(TAG, "ففففففففففففففففففففففففففففففف " + etactivity.getText().toString());
            Intent intentP = getIntent();
            packageName = intentP.getStringExtra("PACKAGE_NAME");
            db.updateData(idst, etactivity.getText().toString(), packageName, eturl.getText().toString());
            eturlst = eturl.getText().toString();

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, time - 1);
            calendar.set(Calendar.MINUTE, 55);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.MILLISECOND, 00);


            Intent alerIntent = new Intent(AddActivity.this, MyReceiver.class);
            alerIntent.putExtra("PACKAGE_NAME", packageName);
            alerIntent.putExtra("URL", eturl.getText().toString());
            alerIntent.putExtra("IDD", id);
            alerIntent.putExtra("ACTIVITY", etactivity.getText().toString());

            AlarmManager alarmManager = (AlarmManager) AddActivity.this.getSystemService(Context.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, PendingIntent.getBroadcast(AddActivity.this, id, alerIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT));
            Log.d(TAG, "ففففففففففففففففففففففففففففففف " + id);


            Intent intent = new Intent(AddActivity.this, TableActivity.class);
            startActivity(intent);
        }
    }

    public  boolean copyDatabase(Context context){
        try{
            InputStream inputStream = context.getAssets().open(db.DbName);
            String outFileName = db.Dblocation + db.DbName;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0)
                outputStream.write(buff,0 , length);
            outputStream.flush();
            outputStream.close();
            return  true;
        }
        catch (Exception e){return  false;}
    }

    public void inputData(){
        etactivity.setText(listActivity.get(id).toString());
        eturl.setText(listURL.get(id).toString());
    }

}