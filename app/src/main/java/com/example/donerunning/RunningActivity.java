package com.example.donerunning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class RunningActivity extends AppCompatActivity {

    private Button startBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);

        startBT = (Button)findViewById(R.id.startBT);
        startBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RunningFinish.class);
                startActivity(intent);
            }
        });
    }

}
