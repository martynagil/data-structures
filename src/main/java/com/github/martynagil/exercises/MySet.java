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
        if (!isInSet(element)) {
            arrayList.add(element);
        }
    }

    public void delete(T element) {
        arrayList.deleteElement(element);
    }

    public T getElement(int index) {
        return arrayList.getElement(index);
    }

    public void iterator() {
        arrayList.iterator();
    }

    public int size() {
        return arrayList.size();
    }

    private boolean isInSet(T element) {
        return arrayList.containElement(element);
    }

}
