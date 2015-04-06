package com.boyko.hack.countoccurences;

import java.util.Map;

public class CountOccurences {

    public static void main(String[] args) {
        Map<String, Integer> occurences = CountWordsOccurences
                .findOccurance("Ninjas are all over the place! We are all going to die!");
        System.out.println(CountWordsOccurences.printMap(occurences));
    }

}
