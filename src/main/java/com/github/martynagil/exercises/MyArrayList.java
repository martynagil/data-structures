package com.github.martynagil.exercises;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> {

    private static final double EXTENSION_THRESHOLD = 0.75;

    private T[] elements;
    private int size;

    public MyArrayList(int length) {
        initialize(length);
        size = 0;
    }

    public MyArrayList() {
        this(6);
    }

    public void add(T element) {
        elements[size] = element;
        adjustArraySize();
        size++;
    }

    public void addAtBeginning(T element) {
        addAtIndex(element, 0);
    }

    public void addAtIndex(T element, int index) {
        if (!(index <= size + 1 && index >= 0)) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (elements[index] != null) {
            System.arraycopy(elements, index, elements, index + 1, elements.length - 1);
            elements[index] = element;
            adjustArraySize();
        } else if (index == size + 1 || elements[size] == null) {
            elements[index] = element;
            adjustArraySize();
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index == size - 1) {
            elements[index] = null;
        } else if (index < (size - 1) && index >= 0) {
            if (elements[index] != null) {
                System.arraycopy(elements, index + 1, elements, index, elements.length - 1);
            }
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
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
        if (index < size && index >= 0) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    public T getLastElement() {
        return elements[size - 1];
    }

    public boolean contain(T element) {
        for (int i = 0; i < size; i++) {
            T item = elements[i];
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        return Arrays.asList(elements).iterator();
    }

    private void initialize(int length) {
        elements = tabCast(length);
    }

    @SuppressWarnings({"unchecked"})
    private T[] tabCast(int length) {
        return (T[]) new Object[length];
    }

    private boolean shouldArrayBeExtended() {
        return (double) size / (double) elements.length > EXTENSION_THRESHOLD;
    }

    public int getSize() {
        return size;
    }

    private void doubleArraySize() {
        T[] tabCastedTemp = elements;
        int length = 2 * elements.length;
        elements = tabCast(length);
        System.arraycopy(tabCastedTemp, 0, elements, 0, elements.length / 2);
    }

    private void adjustArraySize() {
        if (shouldArrayBeExtended()) {
            doubleArraySize();
        }
    }
}
