package com.boyko.hack.doublylinkedstack;

public class StackImpl implements Stack {

    LinkedListImpl dll = new LinkedListImpl();

    @Override
    public void push(int element) {
        dll.add(element);

    }

    @Override
    public int pop() {
        int top = dll.getFirst();
        dll.remove();

        return top;
    }

    @Override
    public int peek() {

        return dll.getFirst();
    }

}
