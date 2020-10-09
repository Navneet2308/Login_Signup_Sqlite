package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_email,et_password;
    DatabaseHelper myDatabaseHelper;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email=findViewById(R.id.edtEmail);
        et_password=findViewById(R.id.edtPassword);

        myDatabaseHelper= new DatabaseHelper(this);


        checkLogin();





    }

    private void checkLogin() {
        SharedPreferences prefs = getSharedPreferences("StoreData", MODE_PRIVATE);
        boolean logindetail = prefs.getBoolean("login", false);
        if (logindetail==true)
        {
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }



    }


    public  void gotosignup(View view)
    {
        Intent intent =new Intent(LoginActivity.this,Signup.class);
        startActivity(intent);
        finish();
    }

    public  void onClicked_login_btn(View view)
    {

        email=et_email.getText().toString();
        password=et_password.getText().toString();
        if (email.equals("") && password.equals("")) {
            Toast.makeText(getApplicationContext(),"Please Insert Email and password",Toast.LENGTH_LONG).show();
        } else {
            int status =Integer.parseInt( myDatabaseHelper.getLoginData(email, password));
            if (status>0) {

                SharedPreferences.Editor editor = getSharedPreferences("StoreData", MODE_PRIVATE).edit();
//                editor.putString("username", getString(cursor.getColumnIndex(cursor.getColumnName(1))));
                editor.putString("Email", email);
                editor.putBoolean("login",true);
                editor.apply();


                Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Invaild Detail!", Toast.LENGTH_LONG).show();

            }
        }

    }



    }
