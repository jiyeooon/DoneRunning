package com.example.donerunning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindIdPw extends AppCompatActivity {

    FragmentManager fragmentManager=getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;

    FindIdFragment findidfragment = new FindIdFragment();
    FindPwFragment findpwfragment = new FindPwFragment();
    private Button find_id, find_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_pw);

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Frame_Layout_idpw, findidfragment).commitAllowingStateLoss();

        find_id = findViewById(R.id.find_id);
        find_id.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.Frame_Layout, findidfragment).commitAllowingStateLoss();
            }
        });

        find_pw = findViewById(R.id.find_pw);
        find_pw.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.Frame_Layout, findpwfragment).commitAllowingStateLoss();
            }
        });
    }
}