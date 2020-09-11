package com.github.martynagil.exercises;

public class MySet<T> {

    private MyArrayList<T> arrayList;

    public MySet(int length) {
        arrayList = new MyArrayList<>(length);
    }

    public MySet() {
        arrayList = new MyArrayList<>();
    }

    public void add(T element) {
        if (!contains(element)) {
            arrayList.add(element);
        }
    }

    public void delete(T element) {
        arrayList.delete(element);
    }

    public T getElement(int index) {
        return arrayList.getElement(index);
    }

    public void iterator() {
        arrayList.iterator();
    }

    public int getSize() {
        return arrayList.getSize();
    }

    public boolean contains(T element) {
        return arrayList.contains(element);
    }

}
