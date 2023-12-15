package com.example.donerunning;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager=getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;

    Home homeFragment = new Home();
    Running runningFragment = new Running();
    Tabata tabataFragment = new Tabata();
    User userFragment = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Frame_Layout, homeFragment).commitAllowingStateLoss();

        //BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        /*bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.running:
                                //running 버튼을 클릭 할 때
                                fragmentTransaction.replace(R.id.Frame_Layout, runningFragment).commitAllowingStateLoss();

                                return true;
                            case R.id.home:
                                //home 버튼을 클릭 할 때
                                fragmentTransaction.replace(R.id.Frame_Layout, homeFragment).commitAllowingStateLoss();
                                return true;
                            case R.id.tabata:
                                //tabata 버튼을 클릭 할 때
                                fragmentTransaction.replace(R.id.Frame_Layout, tabataFragment).commitAllowingStateLoss();
                                return true;
                            case R.id.user:
                                //user 버튼을 클릭 할 때
                                fragmentTransaction.replace(R.id.Frame_Layout, userFragment).commitAllowingStateLoss();
                                return true;
                        }
                        return false;
                    }
                }
        );//
    }
  }
  }
