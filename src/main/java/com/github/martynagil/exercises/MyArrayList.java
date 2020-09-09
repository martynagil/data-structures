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
        elements[getLastEmptyField()] = element;
        checkFillingAndIncreaseSizeIfNecessary();
    }

    public void addAtBeginning(T element) {
        addAtIndex(element, 0);
    }

    public void addAtIndex(T element, int index) {
        if (index <= size() + 1 && index >= 0) {
            if (elements[index] != null) {
                System.arraycopy(elements, index, elements, index + 1, length - 1);
                elements[index] = element;
                checkFillingAndIncreaseSizeIfNecessary();
            } else if (index == size() + 1 || elements[size()] == null) {
                elements[index] = element;
                checkFillingAndIncreaseSizeIfNecessary();
            } else {
                throw new java.lang.IndexOutOfBoundsException("Index out of range");
            }
        } else {
            throw new java.lang.IndexOutOfBoundsException("Index out of range");
        }
    }

    public void deleteAtIndex(int index) {
        if (index == size() - 1) {
            elements[index] = null;
        } else if (index < (size() - 1) && index >= 0) {
            if (elements[index] != null) {
                System.arraycopy(elements, index + 1, elements, index, length - 1);
            }
        } else {
            throw new java.lang.IndexOutOfBoundsException("Index out of range");
        }
    }

    public void deleteElement(T element) {
        for (int i = 0; i < size() ; i++) {
            if (elements[i].equals(element)) {
                deleteAtIndex(i);
            }
        }
    }

    public T getElement(int index) {
        if (index <= size() - 1 && index >= 0) {
            return elements[index];
        } else {
            throw new java.lang.IndexOutOfBoundsException("Index out of range");
        }
    }

    public T getLastElement() {
        return elements[size() - 1];
    }

    public boolean containElement(T element) {
        return Arrays.asList(elements).contains(element);
    }

    public Iterator<T> iterator() {
        return Arrays.asList(elements).iterator();
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

        return (double) size() / (double) length > maxFilling;
    }

    public int size() {
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (elements[i] != null) {
                counter++;
            }
        }
        return counter;
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
    }

    private int getLastEmptyField() {
        int counter = 0;
        if (elements[counter] == null) {
            return counter;
        } else {
            while (elements[counter] != null) {
                counter++;
            }
        }
        return counter;
    }
}
