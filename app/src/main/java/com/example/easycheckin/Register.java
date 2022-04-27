package com.example.easycheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

// https://easycheckin-2caab-default-rtdb.firebaseio.com/



public class Register extends AppCompatActivity {
    private DatabaseReference mDatabase;

    private Boolean registerSuccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }

    public void registerBtn(View view){

        // implement checks that you are successfully registered
        registerSuccess = true;
        if (registerSuccess == true){
            mDatabase = FirebaseDatabase.getInstance().getReference();
            mDatabase.child("easycheckin-2caab-default-rtdb").setValue("dmowen265");

            finish();

        } else {
            Toast.makeText(getApplicationContext(), "Register Failed", Toast.LENGTH_LONG).show();
        }

    }

    public void loginBackBtn(View view){
        finish();
    }
}