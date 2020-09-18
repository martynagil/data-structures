package com.github.martynagil.exercises;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> {

    private static final double EXTENSION_THRESHOLD = 0.75;

    private T[] elements;
    private int size;

    public MyArrayList(int length) {
        elements = createArray(length);
        size = 0;
    }

    public MyArrayList() {
        this(6);
    }

    public void add(T element) {
        add(element, size);
    }

    public void addAtBeginning(T element) {
        add(element, 0);
    }

    public void add(T element, int index) {

        verifyIndexBounds(index, size + 1);

        if (elements[index] != null) {
            move(index, index + 1, index);
        }
        elements[index] = element;
        size++;
        adjustArraySize();
    }

    public void delete(int index) {
        verifyIndexBounds(index, size);

        if (index == size - 1) {
            elements[index] = null;
        } else {
            move(index + 1, index, index);
        }
        size--;
    }

    public void delete(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                delete(i);
            }
        }
    }

    public T get(int index) {
        verifyIndexBounds(index, size);
        return elements[index];
    }

    public T getLast() {
        return elements[size - 1];
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            T item = elements[i];
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        T[] list = createArray(size);
        System.arraycopy(elements, 0, list, 0, size);
        return Arrays.asList(list).iterator();
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings({"unchecked"})
    private T[] createArray(int length) {
        return (T[]) new Object[length];
    }

    private void adjustArraySize() {
        if (shouldArrayBeExtended()) {
            doubleArraySize();
        }
    }

    private boolean shouldArrayBeExtended() {
        return (double) size / elements.length > EXTENSION_THRESHOLD;
    }

    private void doubleArraySize() {
        int oldLength = elements.length;
        T[] tabCastedTemp = elements;
        int newLength = 2 * oldLength;
        elements = createArray(newLength);
        System.arraycopy(tabCastedTemp, 0, elements, 0, oldLength);
    }

    private void verifyIndexBounds(int index, int upperBoundary) {
        if (!(index < upperBoundary && index >= 0)) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    private void move(int scrPos, int dstPos, int index) {
        System.arraycopy(elements, scrPos, elements, dstPos, size - index);
    }
}
