package com.example.donerunning;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.BreakIterator;


public class tabata_start extends AppCompatActivity{
    // 운동시간 카운트 다운
    // editText 값 변환
    EditText edit_sets = (EditText) findViewById(R.id.edit_sets); // 세트수
    EditText edit_actTime = (EditText) findViewById(R.id.edit_act_time); // 운동시간
    EditText edit_restTime = (EditText) findViewById(R.id.edit_rest_time); // 휴식시간



    // 객체 생성(세트수, 운동시간, 휴식시간)
    static class tabata_info{
        int sets;
        int actTime;
        int restTime;
        private BreakIterator edit_sets, edit_actTime, edit_restTime;

        public int sets_get(){
            sets = Integer.parseInt(edit_sets.getText().toString());
            return sets;
        }
        public int acTime_get(){
            actTime = Integer.parseInt(edit_actTime.getText().toString());
            return actTime;
        }
        public int RestTime_get(){
            restTime = Integer.parseInt(edit_restTime.getText().toString());
            return restTime;
        }
    }


    // start 버튼을 누르면
    // activity 전환
    Button startButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabata);

        startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tabata_start.this, tabata_act_time.class);
                startActivity(intent);
            }

        });
    }


}

