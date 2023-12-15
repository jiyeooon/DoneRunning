package com.example.donerunning;

public class RunningInfo {

    public String date;
    public int time;
    public float distance;
    public float rate;
    public int calories;

    public int getTime() { return time; }

    public void setTime(int time) {
        this.time = time;
    }

    public float setDist() { return distance; }

    public void getDist(float distance) { this.distance = distance; }

    public float getRate() { return rate; }

    public void setRate(float rate) { this.rate = rate; }

    public int getCal() { return calories; }

    public void setCal(int calories) { this.calories = calories; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

}
