package com.example.easycheckin;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoggedIn extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    NavController navController;
    NavHostFragment navHostFragment;
    AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        bottomNavigationView = findViewById(R.id.bottomNavView);


         navController = Navigation.findNavController(this, R.id.mainfragment);



       appBarConfiguration = new AppBarConfiguration.Builder(R.id.historyFragment,
               R.id.scanFragment, R.id.createFragment).build();
        NavigationUI.setupActionBarWithNavController(this,navController,
               appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }
}
