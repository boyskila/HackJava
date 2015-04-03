package com.hack.boyko.student;

import java.util.ArrayList;
import java.util.List;

public class Students {

    private String name;
    private String secondName;
    private List<Integer> studentGrades;

    public Students(String name, String secondName, double... grades) {

        studentGrades = new ArrayList<>();
        for (int i = 0; i < grades.length; i++) {
            studentGrades.add((int)grades[i]);
        }

        this.name = name;
        this.setSecondName(secondName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return studentGrades;
    }

    public void setGrades(List<Integer> grades) {
        this.studentGrades = grades;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double averageGrade() {
        double sum = 0;
        int i;
        for (i = 0; i < studentGrades.size(); i++) {
            sum += studentGrades.get(i);

        }
        return sum / i;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   |Grades --> ");
        for (int i = 0; i < studentGrades.size(); i++) {
            sb.append(studentGrades.get(i) + " ");
        }

        return "Name --> " + name + " " + secondName + sb.toString()
                + String.format("average --> %.2f", averageGrade());
    }

}
