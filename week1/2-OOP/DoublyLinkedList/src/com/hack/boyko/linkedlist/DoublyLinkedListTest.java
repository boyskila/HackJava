package com.hack.boyko.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoublyLinkedListTest {

    @Test
    public void dllAllMethods() {

        DoublyLinkedListImpl dll = new DoublyLinkedListImpl();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);
        dll.add(6);
        dll.add(7);

        assertEquals(7, dll.getFirst());
        assertEquals(1, dll.getLast());
        assertEquals(3, dll.getIndexData(4));

    }

}
