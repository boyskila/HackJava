package com.boyko.morethanonecoursesigned;

import java.io.BufferedReader;
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
import org.codehaus.jettison.json.JSONObject;

public class MoreThanOneCourseSigned {
    public static Map<String, JSONArray> readJson(URL fileName) throws Exception {
        StringBuilder response = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(fileName.openStream(), "UTF-8"));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine + "\n");
        }
        in.close();
        Map<String, JSONArray> map = new HashMap<String, JSONArray>();
        JSONArray arr = new JSONArray(response.toString());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject j = new JSONObject(arr.getString(i));
            JSONArray jar = j.getJSONArray("courses");
            String studentName = j.getString("name");
            if (jar.length() > 1) {
                map.put(studentName, jar);
            }
        }
        return map;
    }

    public static List<Entry<String, JSONArray>> sort(Map<String, JSONArray> passedMap) {
        List<Entry<String, JSONArray>> list = new ArrayList<Entry<String, JSONArray>>(passedMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, JSONArray>>() {
            public int compare(Map.Entry<String, JSONArray> o1, Map.Entry<String, JSONArray> o2) {
                JSONArray v1 = o1.getValue();
                JSONArray v2 = o2.getValue();
                return v1.length() == v2.length() ? o1.getKey().compareTo(o2.getKey()) : ((Integer) o2.getValue()
                        .length()).compareTo(o1.getValue().length());
            }
        });
        return list;
    }

    public static void printStudents(URL fileName) throws Exception {
        Map<String, JSONArray> map = readJson(fileName);
        int namesCounter = 0;
        StringBuilder sb = null;
        int courseCounter = 1;
        for (Map.Entry<String, JSONArray> entry : sort(map)) {
            sb = new StringBuilder();
            for (int i = 0; i < entry.getValue().length(); i++) {
                JSONObject obj = entry.getValue().getJSONObject(i);
                sb.append(String.format("%ncourse %d ==> %s", (courseCounter++), obj.getString("name")));
            }
            System.out.printf("%d %s %s %n%n", ++namesCounter, entry.getKey(), sb);
        }
    }

    public static void main(String[] args) throws Exception {
        // printStudents("C:/Users/Bojko/Desktop/students.txt");
        URL url = new URL("https://hackbulgaria.com/api/students/");
        printStudents(url);
    }
}
