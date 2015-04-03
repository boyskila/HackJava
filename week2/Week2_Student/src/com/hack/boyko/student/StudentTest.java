package com.hack.boyko.student;

import java.util.Scanner;

public class StudentTest {

    public static void main(String[] args) {

        SchoolDiary diary = new SchoolDiary();
        Scanner sc = new Scanner(System.in);

        int grades = 0;
        int indexGrades = 0;

        System.out.println("Please enter the number of students");
        int numberOfStudents = sc.nextInt();
        
        while (numberOfStudents > 0) {

            System.out.println("Please enter Student first name");
            String firstName = sc.next();
            System.out.println("Please enter Student second name");
            String secondName = sc.next();

            System.out.println("Type how many grades u want to enter");
            grades = sc.nextInt();
            System.out.println("Enter " + firstName + " ' s " + "grades");

            int[] arr = new int[grades];
            while (indexGrades != arr.length) {

                grades = sc.nextInt();
                arr[indexGrades++] = grades;

            }
            indexGrades = 0;
            diary.addStudent(new Students(firstName, secondName, arr));
            numberOfStudents--;
        }
        sc.close();
        System.out.println(diary.toString());

    }
}
