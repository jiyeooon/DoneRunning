package com.example.donerunning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Home_calandar extends AppCompatActivity {

    // 테이블 동적 할당


    public TableLayout tabata_tablelayout;
    public TableLayout running_tablelayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabata_tablelayout = findViewById(R.id.tabata_chart);
        running_tablelayout = findViewById(R.id.running_chart);

        TableRow tabata_tablerow = new TableRow(this);
        TableRow running_tablerow = new TableRow(this);

        tabata_tablerow.setLayoutParams(new TableRow.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        running_tablerow.setLayoutParams(new TableRow.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        for(int i = 0; i<5; i++){
            TextView tabata_textview = new TextView(this);
            TextView running_textview = new TextView(this);

            tabata_textview.setText(String.valueOf(i));
            running_textview.setText(String.valueOf(i));

            tabata_textview.setGravity(Gravity.CENTER);
            running_textview.setGravity(Gravity.CENTER);

            tabata_textview.setTextSize(20);
            running_textview.setTextSize(20);

            tabata_tablerow.addView(tabata_textview);
            running_tablerow.addView(running_textview);

        }
        tabata_tablelayout.addView(tabata_tablerow);
        running_tablelayout.addView(running_tablerow);
    }

    // 캘린더 (tabata, running 실행 했을 경우 스탬프)
    private final Calendar calendar = Calendar.getInstance();


}

