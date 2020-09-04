package com.github.martynagil.exercises;

public class MyArrayList<T> {

    private int length;
    private Object[] tab;
    private T[] tabCasted;

    public MyArrayList(int length) {
        this.length = length;
        initialize();
    }

    public MyArrayList() {
        length = 6;
        initialize();
    }

    private void initialize() {
        tab = new Object[length];
        tabCasted = tabCast(tab);
    }

    @SuppressWarnings({"unchecked"})
    private T[] tabCast(Object tab) {
        return (T[]) tab;
    }

    private boolean isTabCastedInAtLeast75PercentFilled() {
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (tabCasted[i] != null) {
                counter++;
            }
        }
        return (counter / length) > (3 / 4);
    }

    private T[] twiceTabCastedSize() {
        T[] tabCastedTemp = tabCasted;
        length = 2 * length;
        tab = new Object[length];
        System.arraycopy(tabCastedTemp, 0, tab, 0, length / 2);
        tabCasted = tabCast(tab);
        return tabCasted;
    }

    public void add(T arg) {
        int i = length;
        while (tabCasted[length] == null) {
            i--;
        }
        tabCasted[i] = arg;
    }

}
