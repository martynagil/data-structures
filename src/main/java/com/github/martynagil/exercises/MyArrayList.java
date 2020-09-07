package com.github.martynagil.exercises;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> {

    private int length;
    private T[] elements;

    public MyArrayList(int length) {
        this.length = length;
        initialize();
    }

    public MyArrayList() {
        length = 6;
        initialize();
    }

    public void add(T element) {
        int i = length;
        while (elements[i] == null) {
            i--;
        }
        elements[i] = element;
        checkFillingAndIncreaseSizeIfNecessary();
    }

    public void addAtBeginning(T element) {
        addAtIndex(element, 0);
    }

    public void addAtIndex(T element, int index) {
        if (index <= length || index >= 0) {
            if (elements[index] != null) {
                System.arraycopy(elements, index, elements, index + 1, length - 1);
            }
            elements[index] = element;
            checkFillingAndIncreaseSizeIfNecessary();
        } else {
            throw new java.lang.IndexOutOfBoundsException("Index out of range");
        }
    }

    public void deleteAtIndex(int index) {
        if (index == length) {
            elements[index] = null;
        }
        if (index < length || index >= 0) {
            if (elements[index] != null) {
                System.arraycopy(elements, index + 1, elements, index, length - 1);
            }
        } else {
            throw new java.lang.IndexOutOfBoundsException("Index out of range");
        }
    }

    public void deleteElement(T element) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {
                deleteAtIndex(i);
            }
        }
    }

    public T getElement(int index) {
        if (index <= length || index >= 0) {
            return elements[index];
        } else {
            throw new java.lang.IndexOutOfBoundsException("Index out of range");
        }
    }

    public T getLastElement() {
        int i = length;
        while (elements[i] == null) {
            i--;
        }
        return elements[i - 1];
    }


    public boolean containElement(T element) {
        return Arrays.asList(elements).contains(element);
    }

    public void iterator() {
        Iterator<T> iterator = Arrays.asList(elements).iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    public int size() {
        return length;
    }

    private void initialize() {
        elements = tabCast(new Object[length]);
    }

    @SuppressWarnings({"unchecked"})
    private T[] tabCast(Object tab) {
        return (T[]) tab;
    }

    private boolean shouldArrayBeExtended() {
        double maxFilling = 0.75;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (elements[i] != null) {
                counter++;
            }
        }
        return (double) counter / (double) length > maxFilling;
    }

    private void twiceElementsSize() {
        T[] tabCastedTemp = elements;
        length = 2 * length;
        elements = tabCast(new Object[length]);
        System.arraycopy(tabCastedTemp, 0, elements, 0, length / 2);
    }

    private void checkFillingAndIncreaseSizeIfNecessary() {
        if (shouldArrayBeExtended()) {
            twiceElementsSize();
        }
        if (elements[length] != null) {
            addEmptyField();
        }
    }

    private void addEmptyField() {
        T[] tabCastedTemp = elements;
        length = length + 1;
        elements = tabCast(new Object[length]);
        System.arraycopy(tabCastedTemp, 0, elements, 0, length - 1);
    }
}
