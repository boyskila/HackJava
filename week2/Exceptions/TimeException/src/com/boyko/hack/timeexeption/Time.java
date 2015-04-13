package com.boyko.hack.timeexeption;

import java.util.Calendar;
import java.util.Date;

public class Time {

    int hour, min, sec;
    int year, month, day;

    public Time(int hour, int min, int sec, int year, int month, int day) {
        if (hour > 24 || hour < 0) {
            throw new IllegalArgumentException("Hours shoud be in the range 0 - 24");
        } else if (min > 60 || min < 0) {
            throw new IllegalArgumentException("Minutes shoud be in the range 0 - 60");
        } else if (sec > 60 || sec < 0) {
            throw new IllegalArgumentException("Seconds shoud be in the range 0 - 60");
        } else if (year > 2015) {
            throw new IllegalArgumentException("Year shoud be less than 2016");
        } else if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month shoud be in the range 0 - 12");
        } else if (day > 365 || day < 1) {
            throw new IllegalArgumentException("Days shoud be in the range 1 - 365");
        } else {

            this.hour = hour;
            this.min = min;
            this.sec = sec;
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public String toString() {
        return String.format("%02d:%02d:%02d %02d-%02d-%02d", hour, min, sec, day, month, year);
    }

    public static Time now() {

        Calendar now = Calendar.getInstance();

        Time t = new Time(now.get(Calendar.HOUR), now.get(Calendar.MINUTE), now.get(Calendar.SECOND),
                now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DAY_OF_MONTH));
        return t;
    }
}
