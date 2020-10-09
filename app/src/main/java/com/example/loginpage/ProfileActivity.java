package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtusername, txtuseremail;
    DatabaseHelper myDatabaseHelper;
    private static final String DATABASE_NAME = "users.db";
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtusername = findViewById(R.id.username);
        txtuseremail = findViewById(R.id.useremail);
        myDatabaseHelper = new DatabaseHelper(this);

        prefs = getSharedPreferences("StoreData", MODE_PRIVATE);

        String pre_email = prefs.getString("Email", "no value");


        txtusername.setText(myDatabaseHelper.getname(pre_email));
        txtuseremail.setText(pre_email);
    }



    public  void  logout(View view)
    {
        SharedPreferences preferences =getSharedPreferences("StoreData",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        Intent intent=new Intent(ProfileActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();


    }
}



