package com.hack.boyko.student;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Students> {
    
    Map<Students, Double> gradesPerStudent;
    
    public ValueComparator(Map<Students, Double> gradesPerStudent) {
        this.gradesPerStudent = gradesPerStudent;
    }

    @Override
    public int compare(Students s1, Students s2) {
        Double grade1 = gradesPerStudent.get(s1);
        Double grade2 = gradesPerStudent.get(s2);
        if (grade1.equals(grade2)) {
            return s1.getName().compareTo(s2.getName());
        } else {
            return grade2.compareTo(grade1);
        }
    }

}