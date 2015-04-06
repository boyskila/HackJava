package com.hack.boyko.pairofobjects;

public final class Pair {

    private final Object first, second;

    Pair(Object f, Object s) {

        first = f;
        second = s;

    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public boolean equals(Pair p) {
        return p.first == this.first && p.second == this.second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

}
