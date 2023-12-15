package com.example.donerunning;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RunningFinish extends AppCompatActivity {

    private Button finBT;
    private int distance;
    private int time;
    private int calories;

    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.running_finish);

        //distance 계산

        TextView distanceTV = (TextView) findViewById(R.id.distanceTV);
        distanceTV.setText(distance);

        //calories 계산
        //calories = user.weight * time / 3600 * 8;

        TextView caloriesTV = (TextView) findViewById(R.id.caloriesTV);
        caloriesTV.setText(calories);

        chronometer = (Chronometer) findViewById(R.id.chronometer); //타이머
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.start();

        long current = SystemClock.elapsedRealtime() - chronometer.getBase();
        time = (int) (current / 1000);


        finBT = (Button) findViewById(R.id.FinishBT);
        finBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();

                Intent intent = new Intent(getApplicationContext(), RunningActivity.class);
                startActivity(intent);
            }
        });
    }
}
