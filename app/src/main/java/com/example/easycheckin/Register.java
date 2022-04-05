package com.example.easycheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private Boolean registerSuccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void registerBtn(View view){

        // implement checks that you are successfully registered
        registerSuccess = true;
        if (registerSuccess == true){
            finish();

        } else {
            Toast.makeText(getApplicationContext(), "Register Failed", Toast.LENGTH_LONG).show();
        }

    }

    public void loginBackBtn(View view){
        finish();
    }
}