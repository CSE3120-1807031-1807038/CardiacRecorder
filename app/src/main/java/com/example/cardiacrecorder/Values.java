package com.example.cardiacrecorder;

public class Values {
    String s_pressure;
    String d_pressure;
    String heart_rate;
    String comment;
    String date;
    String time;
    public Values(){}
    public Values(String s_pressure, String d_pressure, String heart_rate,  String date, String time,String comment) {
        this.s_pressure = s_pressure;
        this.d_pressure = d_pressure;
        this.heart_rate = heart_rate;

        this.date = date;
        this.time = time;
        this.comment = comment;
    }

    public String getS_pressure() {
        return s_pressure;
    }

    public void setS_pressure(String s_pressure) {
        this.s_pressure = s_pressure;
    }

    public String getD_pressure() {
        return d_pressure;
    }

    public void setD_pressure(String d_pressure) {
        this.d_pressure = d_pressure;
    }

    public String getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(String heart_rate) {
        this.heart_rate = heart_rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int compareTo(Values values) {
        if(this.s_pressure.compareTo(values.s_pressure)==0){
            if(this.d_pressure.compareTo(values.d_pressure)==0){
                if(this.heart_rate.compareTo(values.heart_rate)==0){
                    return 0;
                }
            }
        }
        return -1;
    }
}
