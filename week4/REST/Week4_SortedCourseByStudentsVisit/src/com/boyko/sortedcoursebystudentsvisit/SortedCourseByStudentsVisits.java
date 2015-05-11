package com.boyko.sortedcoursebystudentsvisit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class SortedCourseByStudentsVisits {
    public static Map<String, Integer> readJSON(String url) throws IOException, JSONException {
        URL fileName = new URL(url);
        StringBuilder webContent = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(fileName.openStream(), "UTF-8"));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            webContent.append(inputLine);
        }
        in.close();
        Map<String, Integer> students = new HashMap<String, Integer>();
        JSONArray arr = new JSONArray(webContent.toString());
        for (int i = 0, a = 0; a < arr.length(); a++) {
            JSONObject j = new JSONObject(arr.getString(a));
            String studentName = j.getString("student_name");
            if (students.containsKey(studentName)) {
                students.put(studentName, students.get(studentName) + 1);
            } else {
                students.put(studentName, i++);
            }
        }
        return students;
    }

    public static List<Entry<String, Integer>> sort(Map<String, Integer> passedMap) {
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(passedMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                Integer v1 = o1.getValue();
                Integer v2 = o2.getValue();
                return v1 == v2 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }

    public static void printStudentsList(String url) throws IOException, JSONException {
        Map<String, Integer> students = readJSON(url);
        for (Map.Entry<String, Integer> entry : sort(students))
            System.out.printf(" %s logged  %d times %n%n", entry.getKey(), entry.getValue());
    }

    public static void main(String[] args) throws Exception {
        printStudentsList("https://hackbulgaria.com/api/checkins/");
    }
}
