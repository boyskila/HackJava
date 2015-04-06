package com.boyko.hack.doublylinkedstack;

public class StackImpl extends DoublyLinkedListImpl implements StackInterface {

    DoublyLinkedListImpl dll = new DoublyLinkedListImpl();

    @Override
    public void push(int element) {
        dll.add(element);

    }

    @Override
    public int pop() {

        return dll.getFirst();
    }

    @Override
    public int peek() {

        return 0;
    }

   @Override
    public void print() {
         dll.print();
    }
    
    

}
