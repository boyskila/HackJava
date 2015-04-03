package com.hack.boyko.student;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SchoolDiary {

    private Map<Students, Double> sortedDiary;
    private Map<Students, Double> diary;
    private ValueComparator vc;

    public SchoolDiary() {
        diary = new HashMap<Students, Double>();
        vc = new ValueComparator(diary);
        sortedDiary = new TreeMap<Students, Double>(vc);
    }

    public void addStudent(Students student) {
        double avarage = student.averageGrade();
        //diary.put(student, avarage);
        sortedDiary.put(student, avarage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Entry<Students, Double> student : sortedDiary.entrySet()) {
            sb.append(student.getKey() + "\n");
        }
        return sb.toString();
    }
}
