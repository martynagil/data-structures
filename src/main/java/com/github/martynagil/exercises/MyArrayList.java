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
        addAtIndex(element, size);
    }

    public void addAtBeginning(T element) {
        addAtIndex(element, 0);
    }

    public void addAtIndex(T element, int index) {

        verifyIndexBounds(index, 0, size + 1);

        if (elements[index] != null) {
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
        elements[index] = element;
        size++;
        adjustArraySize();
    }

    public void deleteAtIndex(int index) {
        verifyIndexBounds(index, 0, size);

        if (index == size - 1) {
            elements[index] = null;
        } else {
            System.arraycopy(elements, index + 1, elements, index, size - index);
        }
        size--;
    }

    public void delete(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                deleteAtIndex(i);
            }
        }
    }

    public T getElement(int index) {
        verifyIndexBounds(index, 0, size);
        return elements[index];
    }

    public T getLastElement() {
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

    private void verifyIndexBounds(int index, int lowerBoundary, int upperBoundary) {
        if (!(index < upperBoundary && index >= lowerBoundary)) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }
}
