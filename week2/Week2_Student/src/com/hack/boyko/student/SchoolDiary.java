package com.hack.boyko.student;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SchoolDiary {

    private Map<Students, Double> sortedDiary;
    private Map<Students, Double> diary;
    private Map<Students, Double> schoolDiary;
    ValueComparator vc = new ValueComparator();

    public SchoolDiary() {
        sortedDiary = new TreeMap<Students, Double>(new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                // TODO Auto-generated method stub
                return 0;
            }
        });

        diary = new HashMap<>();
        sortedDiary = new TreeMap<Students, Double>(diary);
    }

    public void addStudent(Students student) {
        double avarage = student.averageOfGrades();

        diary.put(student, avarage);
        schoolDiary = vc.sortByValue(diary);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Entry<Students, Double> student : schoolDiary.entrySet()) {
            sb.append(student.getKey() + "\n");
        }
        return sb.toString();
    }
}
