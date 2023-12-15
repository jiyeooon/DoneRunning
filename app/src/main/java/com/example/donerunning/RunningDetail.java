package com.example.donerunning;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.view.LineChartView;

public class RunningDetail extends AppCompatActivity implements OnMapReadyCallback {

    public int date;

    private GoogleMap mMap;

    RunningInfo runningInfo = new RunningInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.running_detail);

        //DB에서 값 불러오기

        TextView date = (TextView) findViewById(R.id.dateTV);
        date.setText(runningInfo.date);

        TextView time = (TextView) findViewById(R.id.time);
        time.setText(runningInfo.time);

        TextView distance = (TextView) findViewById(R.id.distance);
        distance.setText((int) runningInfo.distance);

        TextView calories = (TextView) findViewById(R.id.calories);
        calories.setText(runningInfo.calories);

        TextView speed = (TextView)findViewById(R.id.speed);
        speed.setText((int) runningInfo.rate);


        //맵

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        PolylineOptions polylineOptions = new PolylineOptions()
                .add(new LatLng(37.35, -122.0)) //db에서 가져온 값 넣기
                .add(new LatLng(37.45, -122.0))
                .add(new LatLng(37.45, -122.2))
                .add(new LatLng(37.35, -122.2))
                .add(new LatLng(37.35, -122.0));

        Polyline polyline = mMap.addPolyline(polylineOptions);


        //그래프

        LineChartView lineChartView = findViewById(R.id.chart);

        int[] axisData = {};//시간
        float[] yAxisData = {}; //속도

        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        Line line = new Line(yAxisValues);

        //x, y 값 가져오기


        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);
        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);

        axis.setTextSize(16);
        yAxis.setTextSize(16);

   }


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(? , ?))); // 현재 위치
    }
}
