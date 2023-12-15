package com.example.donerunning;


import com.example.donerunning.tabata_start;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.CountDownTimer;


public class tabata_act_time extends AppCompatActivity{
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabata_act);



        // edit을 view로 바꾸기

        tabata_start.tabata_info tabataInfo = new tabata_start.tabata_info();
        int act_actTime = tabataInfo.acTime_get();
        int sets_set = tabataInfo.sets_get();

        TextView setTextView = findViewById(R.id.start_sets);
        TextView actTimeTextView = findViewById(R.id.remainAct_time);

        Intent intent = new Intent(getBaseContext(), tabata_start.class);
        intent.putExtra("sets_set", sets_set);
        setTextView.setText(sets_set);
        intent.putExtra("act_actTime", act_actTime);
        actTimeTextView.setText(act_actTime);

        // 카운트 다운(세트 수, 운동 시간)

        CountDownTimer countDownTimer = new CountDownTimer(act_actTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int num = (int)(millisUntilFinished / 1000);
                actTimeTextView.setText(Integer.toString(num+1));
            }


            // act_actTime == 0이면 restTime activity로 넘어가기
            @Override
            public void onFinish() {
                if(act_actTime == 0){

                    Intent intent = new Intent(tabata_act_time.this, tabata_rest_time.class);
                    startActivity(intent);
                    return;

                }
            }
        }.start();

        // start page로 넘어가고 DB에 새 정보 업데이트
        Button startButton = (Button) findViewById(R.id.act_finish_btn);
        startButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tabata_act_time.this, tabata_start.class);
                startActivity(intent);
            }

        });
    }




}
