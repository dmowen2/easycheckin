package com.example.easycheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Boolean loginSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void loginBtn(View view){
        loginSuccess = true;
        if (loginSuccess == true){
            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoggedIn.class);
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
        }
    }

    public void registerPgBtn(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}