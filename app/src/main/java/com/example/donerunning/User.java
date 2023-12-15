package com.example.donerunning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class User extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_user,container,false);
        Button changebt = (Button)rootview.findViewById(R.id.changeBT);
        Button logoutbt = (Button)rootview.findViewById(R.id.logoutBT);
        Button signoutbt = (Button)rootview.findViewById(R.id.signoutBT);

        changebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfoChangeActivity.class);
                startActivity(intent);
            }
        });

        logoutbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원 계정 삭제
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });

        signoutbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        return rootview;
    }
}
