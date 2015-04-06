package com.boyko.hack.doublylinkedstack;

public class DoublyLinkedStackTest {

    public static void main(String[] args) {
        StackInterface stack = new StackImpl();
        stack.push(2);
        stack.push(5);
        stack.push(10);
        stack.push(1);
        stack.print();
    }
}
