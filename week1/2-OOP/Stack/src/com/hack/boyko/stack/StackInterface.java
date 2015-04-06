package com.hack.boyko.stack;

public interface StackInterface<T> {

    public void push(T element);

    public T pop();

    public boolean isEmpty();

    public int lenght();

    public void clear();

    public T peek();
}
