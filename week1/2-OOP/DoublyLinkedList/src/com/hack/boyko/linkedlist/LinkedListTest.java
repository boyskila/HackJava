package com.hack.boyko.linkedlist;

public class LinkedListTest {

    public static void main(String[] args) {
        DoublyLinkedListImpl dll = new DoublyLinkedListImpl();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);
        dll.add(6);
        dll.add(7);

        int a = dll.getIndexData(4);
        System.out.println(a);

        int b = dll.getLast();
        System.out.println("Last index in the list ==> " + b);

        int c = dll.getFirst();
        System.out.println("First index in the list ==> " + c);

        dll.print();
    }
}
