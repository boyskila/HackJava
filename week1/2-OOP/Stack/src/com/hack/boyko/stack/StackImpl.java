package com.hack.boyko.stack;

import java.util.ArrayList;
import java.util.List;

public class StackImpl<T> implements StackInterface<T> {

    List<T> stack;
    T element;

    public StackImpl() {

        stack = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        stack.add(element);

    }

    @Override
    public T pop() {
        element = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);

        return element;

    }

    @Override
    public boolean isEmpty() {

        return stack.size() == 0;
    }

    @Override
    public int lenght() {
        return stack.size();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public T peek() {

        return stack.get(stack.size() - 1);

    }

}
