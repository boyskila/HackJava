package com.boyko.hack.doublylinkedstack;

import java.util.NoSuchElementException;

public class LinkedListImpl implements LinkedListInterface {

    class Link {
        private int data;

        public Link nextLink;

        public Link(int data) {

            this.data = data;
            nextLink = null;
        }

        public int getData() {
            return data;
        }

    }

    private Link link;
    private int size;

    public LinkedListImpl() {
        link = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {

        return link == null;
    }

    @Override
    public void add(int data) {

        Link newlink = new Link(data);
        newlink.nextLink = link;
        link = newlink;

        size++;
    }

    @Override
    public Link remove() {
        if (link == null)
            throw new NullPointerException();

        link = link.nextLink;

        size--;
        return link;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public int getFirst() {

        return link.getData();
    }

    @Override
    public void print() {

        while (link != null) {
            System.out.println(link.getData());
            link = link.nextLink;
        }

    }

}
