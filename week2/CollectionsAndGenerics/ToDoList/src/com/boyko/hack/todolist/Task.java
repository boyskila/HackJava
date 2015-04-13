package com.boyko.hack.todolist;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private int time;
    private static List<Integer> allTasksTime = new ArrayList<>();
    private int priority;
    private String description;

    public Task(int time, int priority, String description) {

        allTasksTime.add(time);
        this.time = time;
        this.priority = priority;
        this.description = description;

    }

    public float getRemTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public static List<Integer> getAllTasksTime() {
        return allTasksTime;
    }

}