package com.example.popfinder;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.popfinder.Fragments.HomeFragment;
import com.example.popfinder.databinding.ActivityMainBinding;
import com.example.popfinder.databinding.NavDrawerLayoutBinding;
import com.example.popfinder.databinding.ToolbarLayoutBinding;

public class MainActivity extends AppCompatActivity {

    private NavDrawerLayoutBinding navDrawerLayoutBinding;
    private ActivityMainBinding activityMainBinding;
    private ToolbarLayoutBinding toolbarLayoutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );


        navDrawerLayoutBinding = NavDrawerLayoutBinding.inflate ( getLayoutInflater () );
        setContentView ( navDrawerLayoutBinding.getRoot ());
        activityMainBinding = navDrawerLayoutBinding.mainActivity;
        toolbarLayoutBinding = activityMainBinding.toolbar;
        //setSupportActionBar(toolbarLayoutBinding.toolbar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this,
                navDrawerLayoutBinding.navDrawer,
                toolbarLayoutBinding.toolbar,
                R.string.open_navigation_drawer,
                R.string.close_navigation_drawer

        );
        navDrawerLayoutBinding.navDrawer.addDrawerListener(toggle);
        toggle.syncState();

        NavController navController = Navigation.findNavController(this, R.id.fragmentContainer);
        NavigationUI.setupWithNavController(
                navDrawerLayoutBinding.navigationView,
                navController
        );

    }
}