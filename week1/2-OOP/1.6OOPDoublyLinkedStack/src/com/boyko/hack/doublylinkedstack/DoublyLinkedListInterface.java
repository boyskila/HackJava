package com.boyko.hack.doublylinkedstack;

public interface DoublyLinkedListInterface {

    boolean isEmpty();

    void add(int element);

    void removeFirst();

    void removeLast();

    int size();

    int getIndexData(int number);

    int getFirst();

    int getLast();

    void print();

}
