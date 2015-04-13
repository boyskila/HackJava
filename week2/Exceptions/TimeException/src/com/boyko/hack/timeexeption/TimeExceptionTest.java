package com.boyko.hack.timeexeption;

public class TimeExceptionTest {

    public static void main(String[] args) {
        System.out.println(Time.now());
        Time t = new Time(25, 12, 12, 1222, 2, 2);
        System.out.println(t);
    }
}
