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
        addAtIndex(element, size);
    }

    public void addAtBeginning(T element) {
        addAtIndex(element, 0);
    }

    public void addAtIndex(T element, int index) {
        if (!(index <= size && index >= 0)) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (elements[index] != null) {
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
        elements[index] = element;
        size++;
        adjustArraySize();
    }

    public void deleteAtIndex(int index) {
        if (!(index < size && index >= 0)) {
            throw new IndexOutOfBoundsException("Index out of range");
        } else if (index == size - 1) {
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
        if (index < size && index >= 0) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
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

    private void initialize(int length) {
        elements = createArray(length);
    }

    @SuppressWarnings({"unchecked"})
    private T[] createArray(int length) {
        return (T[]) new Object[length];
    }

    private boolean shouldArrayBeExtended() {
        return (double) size / elements.length > EXTENSION_THRESHOLD;
    }

    public int getSize() {
        return size;
    }

    private void doubleArraySize() {
        int oldLength = elements.length;
        T[] tabCastedTemp = elements;
        int newLength = 2 * oldLength;
        elements = createArray(newLength);
        System.arraycopy(tabCastedTemp, 0, elements, 0, oldLength);
    }

    private void adjustArraySize() {
        if (shouldArrayBeExtended()) {
            doubleArraySize();
        }
    }
}
