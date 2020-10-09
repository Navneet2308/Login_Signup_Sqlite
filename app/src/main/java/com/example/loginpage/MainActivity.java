package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void gotoprofile(View view)
    {
        Intent intent =new Intent(MainActivity.this,ProfileActivity.class);
        startActivity(intent);
    }

    public  void gotoscreen1(View view)
    {
        Intent intent =new Intent(MainActivity.this,Screen1.class);
        startActivity(intent);
    }

    public  void gotoscreen2(View view)
    {
        Intent intent =new Intent(MainActivity.this,Screen2.class);
        startActivity(intent);
    }
}