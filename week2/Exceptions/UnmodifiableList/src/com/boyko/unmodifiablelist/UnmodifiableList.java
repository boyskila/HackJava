package com.boyko.unmodifiablelist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.UnaryOperator;

import org.apache.commons.lang3.SerializationUtils;

public final class UnmodifiableList<T extends Serializable> extends ArrayList<T> implements Iterable<T> {

    private static final long serialVersionUID = 1L;

    List<byte[]> serializedCollection = new ArrayList<>();

    public UnmodifiableList(Collection<? extends T> collection) { // Constructor

        for (T t : collection) {

            serializedCollection.add(SerializationUtils.serialize(t));

        }

    }

    @SafeVarargs
    public static <T extends Serializable> List<T> asList(T... arguments) {

        return new UnmodifiableList<T>(Arrays.asList(arguments));

    }

    public int size() {
        return serializedCollection.size();
    }

    public T get(int index) {
        return SerializationUtils.deserialize(serializedCollection.get(index));

    }

    @Override
    public Iterator<T> iterator() {

        return new MyIterator(serializedCollection.iterator());
    }

    class MyIterator implements Iterator<T> {
        Iterator<byte[]> iterator;

        public MyIterator(Iterator<byte[]> serializedCollection) {
            this.iterator = serializedCollection;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();

        }

        @Override
        public T next() {

            return SerializationUtils.deserialize(iterator.next());
        }

    }

    public boolean add(T element) {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    public void add(int index, T element) {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    public boolean remove() {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    public T remove(int index) {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    public boolean remove(Object element) {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException(
                "This is immutable collection and its impossible to add,remove,get and etc. from it");
    }
}
