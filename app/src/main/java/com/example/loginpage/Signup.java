package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText et_email,et_password,et_name;
    Button buttonRegister;
    DatabaseHelper myDatabaseHelper;
    String email,password,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_email=findViewById(R.id.edtEmail);
        et_name=findViewById(R.id.edName);
        et_password=findViewById(R.id.edtPassword);
        buttonRegister=findViewById(R.id.signup_btn);


        myDatabaseHelper= new DatabaseHelper(this);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicked_signup_btn();
            }
        });


    }

    public void onclicked_signup_btn()
    {

        email=et_email.getText().toString();
        password=et_password.getText().toString();
        name=et_name.getText().toString();
        int userexits =Integer.parseInt( myDatabaseHelper.usereexits(email));
        if (email.equals("") || password.equals("") || name.equals("")) {
            Toast.makeText(getApplicationContext(),"Please Fill all",Toast.LENGTH_LONG).show();
        }

        else if (!isValidMail(email) && !isValidMobile(email))
        {
            Toast.makeText(getApplicationContext(),"Please enter vaild email or mobile number",Toast.LENGTH_LONG).show();
        }

        else if (userexits>0)
        {
            Toast.makeText(getApplicationContext(),"This email or mobile number already used",Toast.LENGTH_LONG).show();
        }

        else {
            boolean status = myDatabaseHelper.addUser(name,email,password);
            if (status) {
                Toast.makeText(getApplicationContext(), "Registration Successfully", Toast.LENGTH_LONG).show();
                Intent intent =new Intent(Signup.this,LoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "You are not Registerd!", Toast.LENGTH_LONG).show();

            }
        }

    }






    public void onclicked_back_btn(View view)
    {
        Intent intent =new Intent(Signup.this,LoginActivity.class);
        startActivity(intent);
        finish();

    }


    private boolean isValidMail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
}