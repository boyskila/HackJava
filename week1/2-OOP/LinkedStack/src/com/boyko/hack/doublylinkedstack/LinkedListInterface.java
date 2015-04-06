package com.boyko.hack.doublylinkedstack;

import com.boyko.hack.doublylinkedstack.LinkedListImpl.Link;

public interface LinkedListInterface {

    boolean isEmpty();

    void add(int element);

    Link remove();

    int size();

    int getFirst();

    void print();

}
