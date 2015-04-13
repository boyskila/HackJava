package com.boyko.hack.todolist;

public class ToDoListMain {

    public static void main(String[] args) throws InterruptedException {

        ToDoList todo = new ToDoList();

        Task running = new Task(1, 6, "Running Task");
        Task algebra = new Task(2, 4, "Algebra Task");
        Task sleeping = new Task(8, 8, "Sleeping Task");
        Task programming = new Task(10, 10, "Programming Task");
        Task drinkingBeer = new Task(2, 5, "Drinking Beer Task");

        todo.addTask(algebra);
        todo.addTask(sleeping);
        todo.addTask(running);
        todo.addTask(programming);
        todo.addTask(drinkingBeer);
        todo.markFinishedTask(running);
        todo.markFinishedTask(algebra);
      //  todo.markFinishedTask(sleeping);
        todo.markFinishedTask(programming);
        // todo.markFinishedTask(drinkingBeer);

        System.out.printf("%.1f hours left for %s\n", programming.getRemTime(), programming.getDescription());
        System.out.println("\n============\nTask list\n-------------------");
        for (Task task : todo)
            System.out.println(task.getDescription());
        System.out.println("==================");

        System.out.printf("Are all tasks complete? ==> %s \n=================\n", todo.canFinish());
        System.out.printf("Need %d hours to complete all tasks\n", todo.getTimeNeeded());
        System.out.printf("The most important task ==> %s", todo.getTop().getDescription());

        System.out.println("\n---------------\nIs finish?\n---------------\n");
        if (todo.canFinish()) {
            System.out.println("Woohoo!");
        } else {
            System.out.println("I am ...screwed :(");
        }
    }

}
