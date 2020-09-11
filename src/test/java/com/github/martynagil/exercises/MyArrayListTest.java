package com.github.martynagil.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyArrayListTest {

    private static final String ELEMENT = "String";
    private static final String ITEM = "Item";

    @Test
    void shouldAddElementAtTheEnd() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(ELEMENT);
        list.add(ELEMENT);
        list.add(ELEMENT);
        list.add(ITEM);

        assertThat(list.getLastElement()).isEqualTo(ITEM);
    }

    @Test
    void shouldAddAtTheBeginning() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(ELEMENT);
        list.add(ELEMENT);
        list.add(ELEMENT);
        list.addAtBeginning(ITEM);

        assertThat(list.getElement(0)).isEqualTo(ITEM);
    }

    @Test
    void shouldAddAtIndex() {
        MyArrayList<String> list = new MyArrayList<>();
        int index = 2;

        list.add(ELEMENT);
        list.add(ELEMENT);
        list.add(ELEMENT);
        list.addAtIndex(ITEM, index);

        assertThat(list.getElement(index)).isEqualTo(ITEM);
    }

    @Test
    void shouldNotAddElementWhenIndexIsOutOfBounds() {
        int index = 8;

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> new MyArrayList<String>().addAtIndex(ELEMENT, index)
        );
    }

    @Test
    void shouldDeleteElement() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(ITEM);
        list.add(ITEM);
        list.add(ELEMENT);
        list.add(ITEM);
        list.delete(ELEMENT);

        assertThat(list.contains(ELEMENT)).isFalse();
    }

    @Test
    void shouldNotDeleteElementByIndex() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(ELEMENT);
        list.add(ITEM);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> new MyArrayList<String>().deleteAtIndex(3)
        );
    }

    @Test
    void shouldGiveElementByIndex() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(ELEMENT);

        assertThat(list.getElement(0)).isEqualTo(ELEMENT);
    }

    @Test
    void shouldNotGiveElementByIndex() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(ELEMENT);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> new MyArrayList<String>().getElement(1)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 50, 100})
    void shouldExtendProperly(int ints) {
        MyArrayList<String> list = new MyArrayList<>();

        for (int i = 0; i < ints; i++) {
            list.add(ELEMENT);
        }

        assertThat(list.getSize()).isEqualTo(ints);
    }
}