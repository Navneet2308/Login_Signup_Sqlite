package com.example.loginpage;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;


/**
 * This class provides some (basic) database functionality.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";

    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_USERS + "(" + COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_NAME + " text not null, " + COLUMN_EMAIL +
            " text not null, " +
            COLUMN_PASSWORD + " text not null);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase database) {
        // Create the database with the database creation statement.
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if (oldVersion > 1) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
        //}
    }
    public boolean addUser(String name, String email, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(COLUMN_NAME,name);
        c.put(COLUMN_EMAIL,email);
        c.put(COLUMN_PASSWORD,password);
        long result=db.insert(TABLE_USERS,null,c);
        if (result==-1){
            return false;
        } else {
            return true;
        }

    }

    public String getLoginData(String email,String password)
    {
        SQLiteDatabase sql=this.getReadableDatabase();
        String query=" select count(*) from "+TABLE_USERS+" where email ='"+email+"' and password='"+password+"'";
        Cursor cursor =sql.rawQuery(query,null);
        cursor.moveToFirst();
        String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));


        return count;

    }

    public String getname( String email) {
        String selectQuery = " select  * from "+TABLE_USERS+" where email ='"+email+"'" ;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String data      = null;

        if (cursor.moveToFirst()) {
            do {
               data=cursor.getString(1);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }


    public String usereexits(String email)
    {
        SQLiteDatabase sql=this.getReadableDatabase();
        String query=" select count(*) from "+TABLE_USERS+" where email ='"+email+"'";
        Cursor cursor =sql.rawQuery(query,null);
        cursor.moveToFirst();
        String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return count;

    }



}
