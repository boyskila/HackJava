package com.hack.boyko.linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedListImpl implements DoublyLinkedListInterface {

    class Link {
        private int data;
        public Link previousLink;
        public Link nextLink;

        public Link(int data) {
            previousLink = null;
            this.data = data;
            nextLink = null;
        }

        public Link(Link previousLink, int data, Link nextLink) {
            this.previousLink = previousLink;
            this.data = data;
            this.nextLink = nextLink;
        }

        public int getData() {
            return data;
        }

    }

    private Link link;
    private int size;

    public DoublyLinkedListImpl() {
        link = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {

        return link == null;
    }

    @Override
    public void add(int data) {
        if (isEmpty()) {
            link = new Link(null, data, null);
        } else {
            Link newlink = new Link(link, data, null);
            link.nextLink = newlink;
            link = newlink;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (link == null)
            return;

        link = link.previousLink;
        link.nextLink = null;
        size--;

    }

    @Override
    public void removeLast() {
        if (link == null)
            return;

        if (link.previousLink == null) {
            link = null;
            size--;
            return;
        }
        Link current = link;
        while (current.previousLink.previousLink != null) {
            current = current.previousLink;
        }
        current.previousLink = null;
        size--;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public int getIndexData(int index) {
        if (index < 1 || index > size)
            throw new NoSuchElementException();

        Link current = link;
        int i = 0;
        while (i < index) {
            current = current.previousLink;
            i++;
            if (i == index) {
                return current.getData();
            }

        }
        return 0;
    }

    @Override
    public int getFirst() {

        return link.getData();
    }

    @Override
    public int getLast() {

        return getIndexData(size - 1);
    }

    @Override
    public void print() {

        while (link != null) {
            System.out.println(link.getData());
            link = link.previousLink;
        }

    }

}
