package com.boyko.hack.doublylinkedstack;

public class LinkedStackTest {

    public static void main(String[] args) {
        Stack stack = new StackImpl();
        stack.push(12);
        stack.push(2);
        stack.push(5);
        stack.push(10);
        stack.push(1);

        int a = stack.pop();
        System.out.println(a);
        int b = stack.pop();
        System.out.println(b);

        System.out.println(stack.peek());
    }
}
