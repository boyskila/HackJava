package com.boyko.hack.todolist;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: Crunchify.com
 */

public class Time {
    private Toolkit toolkit;
    private Timer timer;
    private int time;
    private int reminderPeriod;

    public Time(int time, int remainderPeriod) {
        this.reminderPeriod = remainderPeriod;
        this.time = time;
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), 0, time * 1000);
    }

    public Time(int timeBetweenTasks) {

       
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), 0, timeBetweenTasks * 1000);
    }

    class RemindTask extends TimerTask {
        int numWarningBeeps = reminderPeriod;

        public void run() {
            if (numWarningBeeps > 0) {
                toolkit.beep();
                System.out.printf("Remaining task time %dmin\n", time -= reminderPeriod);
                numWarningBeeps--;
            } else {
                toolkit.beep();
                System.out.println("Time's up! I am ...screwed :(");
                timer.cancel();
            }
        }
    }

    public static void main(String args[]) {
        // new Time(10, 3);
    }
}