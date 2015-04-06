package com.hack.boyko.stack;

import java.util.ArrayList;
import java.util.List;

public class StackVariant<T> extends StackImpl<T> {

    List<T> stack = new ArrayList<>();

    StackVariant() {
        super();

    }

    @Override
    public void push(T element) {
        if (stack.isEmpty()) {
            stack.add(element);
        } else {

            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i).equals(element)) {
                    throw new IllegalArgumentException("Not allowed duplicate objects in the stack");
                } else {
                    stack.add(element);
                }
            }
        }
    }

}
