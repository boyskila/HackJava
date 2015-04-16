package com.boyko.unmodifiablelist;

import java.util.List;

public class UnmodifiableListMain {

    public static void main(String[] args) {

        List<Integer> intList = UnmodifiableList.asList(1, 2, 3, 4, 5, 6);

        // intList.add(10);
        // intList.remove(5);
        // intList.add(0, 10);
        // throw UnsupportedOperationException if try to add or remove...

        int a = intList.get(3);
        int b = intList.get(2);

        System.out.printf("Just peek %d and %d%n", a, b);
        System.out.print("The list contains ==> ");

        for (Integer integer : intList)
            System.out.print(integer + " ");

    }
}
