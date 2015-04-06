package com.hack.boyko.student;

import java.util.Scanner;

public class StudentTest {

    public static void main(String[] args) {

        SchoolDiary diary = new SchoolDiary();

        Students st1 = new Students("Pesho", "Ivanov", 5);
        Students st2 = new Students("Aenka", "georgieva", 3, 6, 3, 6, 5);
        Students st3 = new Students("Gosho", "hahaha", 5, 5, 5, 6, 2);
        Students st4 = new Students("Ivo", "Ivanov", 3, 4, 6, 6, 6);
        diary.addStudent(st1);
        diary.addStudent(st2);
        diary.addStudent(st3);
        diary.addStudent(st4);

        System.out.println(diary.toString());

    }
}
