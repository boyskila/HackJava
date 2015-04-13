package com.boyko.hack.todolist;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class ToDoList implements Iterable<Task> {

    static PriorityQueue<Task> tasks;
    private int remainingTime;

    public ToDoList() {

        tasks = new PriorityQueue<Task>(new Comparator<Task>() {

            @Override
            public int compare(Task t1, Task t2) {
                int p1 = t1.getPriority();
                int p2 = t2.getPriority();
                return p1 == p2 ? 0 : p1 < p2 ? 1 : -1;
            }
        });
    }

    public void addTask(Task whatToDo) {
        tasks.offer(whatToDo);
    }

    public int getTimeNeeded() {

        for (int i = 0; i < Task.getAllTasksTime().size(); i++)
            // updated after every marked task
            remainingTime += Task.getAllTasksTime().get(i);

        return remainingTime;
    }

    public Task getTop() {
        return tasks.peek();
    }

    public void markFinishedTask(Task t) {

        for (int i = 0; i < Task.getAllTasksTime().size(); i++) {
            if (t.getRemTime() == Task.getAllTasksTime().get(i)) {
                Task.getAllTasksTime().remove(i); // remove task time from
                                                  // the timeList
                break;
            }
        }
        tasks.remove(t);
    }

    public boolean canFinish() {
        return tasks.isEmpty();
    }

    @Override
    public Iterator<Task> iterator() {

        return tasks.iterator();
    }

}
