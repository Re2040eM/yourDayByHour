package com.year.Day24hours;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    private static final String TAG = "TableActivity";
    ArrayList listActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        this.setTitle("جدولك اليومي");

        File database = getApplicationContext().getDatabasePath(db.DbName);
        if (false == database.exists()) {
            db.getReadableDatabase();
            if (copyDatabase(this)) {
            }
            else {
            }
        }
        listActivity = db.get_All_Activity();

        TextView tx0 = (TextView) findViewById(R.id.tv0);
        tx0.setText(listActivity.get(0).toString());

        TextView tx1 = (TextView) findViewById(R.id.tv1);
        tx1.setText(listActivity.get(1).toString());

        TextView tx2 = (TextView) findViewById(R.id.tv2);
        tx2.setText(listActivity.get(2).toString());

        TextView tx3 = (TextView) findViewById(R.id.tv3);
        tx3.setText(listActivity.get(3).toString());

        TextView tx4 = (TextView) findViewById(R.id.tv4);
        tx4.setText(listActivity.get(4).toString());

        TextView tx5 = (TextView) findViewById(R.id.tv5);
        tx5.setText(listActivity.get(5).toString());

        TextView tx6 = (TextView) findViewById(R.id.tv6);
        tx6.setText(listActivity.get(6).toString());

        TextView tx7 = (TextView) findViewById(R.id.tv7);
        tx7.setText(listActivity.get(7).toString());

        TextView tx8 = (TextView) findViewById(R.id.tv8);
        tx8.setText(listActivity.get(8).toString());

        TextView tx9 = (TextView) findViewById(R.id.tv9);
        tx9.setText(listActivity.get(9).toString());

        TextView tx10 = (TextView) findViewById(R.id.tv10);
        tx10.setText(listActivity.get(10).toString());

        TextView tx11 = (TextView) findViewById(R.id.tv11);
        tx11.setText(listActivity.get(11).toString());

        TextView tx12 = (TextView) findViewById(R.id.tv12);
        tx12.setText(listActivity.get(12).toString());

        TextView tx13 = (TextView) findViewById(R.id.tv13);
        tx13.setText(listActivity.get(13).toString());

        TextView tx14 = (TextView) findViewById(R.id.tv14);
        tx14.setText(listActivity.get(14).toString());

        TextView tx15 = (TextView) findViewById(R.id.tv15);
        tx15.setText(listActivity.get(15).toString());

        TextView tx16 = (TextView) findViewById(R.id.tv16);
        tx16.setText(listActivity.get(16).toString());

        TextView tx17 = (TextView) findViewById(R.id.tv17);
        tx17.setText(listActivity.get(17).toString());

        TextView tx18 = (TextView) findViewById(R.id.tv18);
        tx18.setText(listActivity.get(18).toString());

        TextView tx19 = (TextView) findViewById(R.id.tv19);
        tx19.setText(listActivity.get(19).toString());

        TextView tx20 = (TextView) findViewById(R.id.tv20);
        tx20.setText(listActivity.get(20).toString());

        TextView tx21 = (TextView) findViewById(R.id.tv21);
        tx21.setText(listActivity.get(21).toString());

        TextView tx22 = (TextView) findViewById(R.id.tv22);
        tx22.setText(listActivity.get(22).toString());

        TextView tx23 = (TextView) findViewById(R.id.tv23);
        tx23.setText(listActivity.get(23).toString());
    }

    public void onClickBut0(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "0");
        startActivity(intent);
    }

    public void onClickBut1(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "1");
        startActivity(intent);
    }

    public void onClickBut2(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "2");
        startActivity(intent);
    }

    public void onClickBut3(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "3");
        startActivity(intent);
    }

    public void onClickBut4(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "4");
        startActivity(intent);
    }

    public void onClickBut5(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "5");
        startActivity(intent);
    }

    public void onClickBut6(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "6");
        startActivity(intent);
    }

    public void onClickBut7(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "7");
        startActivity(intent);
    }

    public void onClickBut8(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "8");
        startActivity(intent);
    }

    public void onClickBut9(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "9");
        startActivity(intent);
    }

    public void onClickBut10(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "10");
        startActivity(intent);
    }

    public void onClickBut11(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "11");
        startActivity(intent);
    }

    public void onClickBut12(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "12");
        startActivity(intent);
    }

    public void onClickBut13(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "13");
        startActivity(intent);
    }

    public void onClickBut14(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "14");
        startActivity(intent);
    }

    public void onClickBut15(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "15");
        startActivity(intent);
    }

    public void onClickBut16(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "16");
        startActivity(intent);
    }

    public void onClickBut17(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "17");
        startActivity(intent);
    }

    public void onClickBut18(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "18");
        startActivity(intent);
    }

    public void onClickBut19(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "19");
        startActivity(intent);
    }

    public void onClickBut20(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "20");
        startActivity(intent);
    }

    public void onClickBut21(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "21");
        startActivity(intent);
    }

    public void onClickBut22(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "22");
        startActivity(intent);
    }

    public void onClickBut23(View view) {
        Intent intent = new Intent(TableActivity.this, AddActivity.class);
        intent.putExtra("BUT_TEXT", "23");
        startActivity(intent);
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

    public void onClickback(View view) {
        Intent intent = new Intent(TableActivity.this, MyActivity.class);
        startActivity(intent);

    }

}

