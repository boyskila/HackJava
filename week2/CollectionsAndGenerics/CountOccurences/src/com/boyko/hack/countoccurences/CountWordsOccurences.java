package com.boyko.hack.countoccurences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CountWordsOccurences {

    public CountWordsOccurences() {

    }

    static Map<String, Integer> findOccurance(String text) {
        String[] arr = text.split(" ");
        List<String> list = Arrays.asList(arr);
        Map<String, Integer> scoreboard = new LinkedHashMap<>();

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {

            String word = it.next();

            if (scoreboard.containsKey(word)) {
                scoreboard.put(word, scoreboard.get(word) + 1);
            } else {
                scoreboard.put(word, 1);
            }
        }
        return scoreboard;
    }

    static String printMap(Map<String, Integer> scoreboard) {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (String key : scoreboard.keySet()) {
            Integer value = scoreboard.get(key);
            sb.append(String.format("%s:%d ", key, value));
        }
        sb.append("}");
        return sb.toString();

    }

}
