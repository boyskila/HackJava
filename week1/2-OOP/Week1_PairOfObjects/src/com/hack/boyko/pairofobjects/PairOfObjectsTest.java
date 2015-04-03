package com.hack.boyko.pairofobjects;

public class PairOfObjectsTest {

    public static void main(String[] args) {

        Pair p = new Pair("y", "x");
        Pair b = new Pair("x", "x");

        System.out.println(b.equals(p));
    }

}
