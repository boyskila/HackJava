package com.hack.boyko.time;

import java.util.Calendar;
import java.util.Date;

public class Time {

    int hour, min, sec;
    int year, month, day;

    public Time(int hour, int min, int sec, int year, int month, int day) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public String toString() {
        return String.format("%02d:%02d:%02d %02d-%02d-%02d", hour, min, sec, day, month, year);
    }

    public static Time now() {

        Calendar now = Calendar.getInstance();
        Date date = new Date();

        Time t = new Time(date.getHours(), date.getMinutes(), date.getSeconds(), now.get(Calendar.YEAR),
                now.get(Calendar.MONTH) + 1, now.get(Calendar.DAY_OF_MONTH));
        return t;
    }
}
