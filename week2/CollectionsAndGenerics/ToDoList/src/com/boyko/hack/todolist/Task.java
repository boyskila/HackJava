package com.boyko.hack.todolist;

public class Task {

    private int time;

    private int priority;
    private String description;

    public Task(int time, int priority, String description) {

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
}