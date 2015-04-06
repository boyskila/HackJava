package com.hack.boyko.stack;

import java.util.ArrayList;
import java.util.List;

public class StackTest {
    static List<Object> arr = new ArrayList<>();
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static <T> void main(String[] args) {

        StackVariant<Integer> stack = new StackVariant<>();

        System.out.println(stack.isEmpty());
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(2);
        System.out.println(stack.isEmpty());

        System.out.println(stack.isEmpty());
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(2);
        System.out.println(stack.isEmpty());

    }

}
