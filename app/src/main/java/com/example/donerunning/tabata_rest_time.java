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


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tabata_rest_time extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabata_act);

        // onClick finish 누르면 start page로 넘어가고 DB에 새 정보 업데이트
        Button startButton = (Button) findViewById(R.id.act_finish_btn);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tabata_rest_time.this, tabata_start.class);
                startActivity(intent);
            }
        });


        tabata_start.tabata_info tabataInfo = new tabata_start.tabata_info();

        int rest_sets = tabataInfo.sets_get();
        int rest_restTime = tabataInfo.RestTime_get();

        //TextView setTextView = findViewById(R.id.tabata);
        TextView restTimeTextView = findViewById(R.id.remainRest_time);

        Intent intent = new Intent(getBaseContext(), tabata_start.class);
        intent.putExtra("rest_sets", rest_sets);
        //setTextView.setText(rest_sets);
        intent.putExtra("act_actTime", rest_restTime);
        restTimeTextView.setText(rest_restTime);



        // 휴식시간 == 0 이면 세트수 -1

        CountDownTimer countDownTimer = new CountDownTimer(rest_restTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int num = (int)(millisUntilFinished / 1000);
                restTimeTextView.setText(Integer.toString(num+1));

            }


            @Override
            public void onFinish() {
                if(rest_sets!=0){
                    Intent intent = new Intent(tabata_rest_time.this, tabata_act_time.class);
                    startActivity(intent);
                }
                else if(rest_sets ==0){
                    Intent intent = new Intent(tabata_rest_time.this, tabata_start.class);
                    startActivity(intent);
                }
            }
        }.start();
        // for(세트수 만큼 반복)
        // rest_restTime == 0이면 세트수 -=1
        // actTime activity로 넘어가기
        // 세트수 == 0 되면 start page로 넘기기

    }
}

