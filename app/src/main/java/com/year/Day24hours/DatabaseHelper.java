package com.year.Day24hours;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{
    long result;

    public static final String  DbName ="allActivity.db";
    public static final String Dblocation = Environment.getDataDirectory() + "/data/com.year.Day24hours/databases/";

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context){
        super(context,DbName,null,1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void openDatabase(){
        String dbPath = mContext.getDatabasePath(DbName).getPath();
        if(mDatabase != null && mDatabase.isOpen())
            return;
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase(){
        if (mDatabase != null)
            mDatabase.close();
    }

    public ArrayList get_All_Activity(){
        ArrayList arrayList = new ArrayList();
        openDatabase();
        Cursor res = mDatabase.rawQuery("select * from sunActivity", null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            arrayList.add(res.getString(res.getColumnIndex("ACTIVITYS")));
            res.moveToNext();
        }
        res.close();
        closeDatabase();
        return arrayList;
    }

    public ArrayList get_All_URL(){
        ArrayList arrayList = new ArrayList();
        openDatabase();
        Cursor res = mDatabase.rawQuery("select * from sunActivity", null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            arrayList.add(res.getString(res.getColumnIndex("URL")));
            res.moveToNext();
        }
        res.close();
        closeDatabase();
        return arrayList;
    }

    public ArrayList get_All_PackName(){
        ArrayList arrayList = new ArrayList();
        openDatabase();
        Cursor res = mDatabase.rawQuery("select * from sunActivity", null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            arrayList.add(res.getString(res.getColumnIndex("PACKAGENAME")));
            res.moveToNext();
        }
        res.close();
        closeDatabase();
        return arrayList;
    }

    public boolean updateData (String id, String activity, String packageName, String url){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("id", id);
    contentValues.put("ACTIVITYS", activity);
    contentValues.put("PACKAGENAME", packageName);
    contentValues.put("URL", url);
    db.update("sunActivity", contentValues,"id= ?", new String[]{id});
    return true;
    }

}

/**public boolean InsertSun(String packageApp, String ACTIVIT, String URL, int TIME, int YEAR, int MONTH, int DAYNUM){
 SQLiteDatabase db = this.getWritableDatabase();
 ContentValues contentValues = new ContentValues();

 contentValues.put("ACTIVIT", ACTIVIT);
 contentValues.put("URL", URL);
 contentValues.put("TIME", TIME);
 contentValues.put("YEAR", YEAR);
 contentValues.put("MONTH", MONTH);
 contentValues.put("DAYNUM", DAYNUM);
 result = db.insert("Sun", null, contentValues);

 if(result == -1)
 return false;
 else
 return true;
 } */



