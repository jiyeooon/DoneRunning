package com.example.donerunning;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FindIdFragment extends Fragment {

    private EditText name, email;
    private Button okbt, cancelbt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_find_id, container, false);

        name = rootview.findViewById(R.id.nameET);
        email = rootview.findViewById(R.id.emailET);

        okbt = (Button)rootview.findViewById(R.id.okBT);
        okbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DB에서 name 가진 이름의 e-mail가져오기
                //가져온 e-mail과 사용자입력email이 같은지 확인하기
                //같다면 email 전송
            }
        });
        cancelbt = (Button)rootview.findViewById(R.id.cancelBT);
        cancelbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = email = null;
            }
        });

        return rootview;
    }
}