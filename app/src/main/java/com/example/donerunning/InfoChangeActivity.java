package com.example.donerunning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class InfoChangeActivity extends AppCompatActivity {

    private EditText name, nickname, pw, height, weight, email, age;
    private Button okbt, cancelbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_change);

        name = findViewById( R.id.nameET );
        nickname = findViewById( R.id.nicknameET );
        pw = findViewById( R.id.pwET );
        height = findViewById( R.id.heightET );
        weight = findViewById( R.id.weightET );
        email = findViewById( R.id.emailET );
        age = findViewById( R.id.ageET );

        okbt = findViewById(R.id.okBT);

        okbt.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                //DB에 새 정보 업데이트

            }
        });
        cancelbt = findViewById(R.id.cancelBT);
        cancelbt.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                name = nickname = pw = height = weight = email = age = null;
            }
        });
    }
}
