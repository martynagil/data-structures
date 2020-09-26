package com.github.martynagil.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyArrayListTest {

    private static final String ELEMENT_1 = "String";
    private static final String ELEMENT_2 = "Item";

    @Test
    void shouldAddElementAtTheEnd() {
        MyArrayList<String> list = initList();

        list.add(ELEMENT_2);

        assertThat(list.getLast()).isEqualTo(ELEMENT_2);
    }

    @Test
    void shouldAddAtTheBeginning() {
        MyArrayList<String> list = initList();

        list.addAtBeginning(ELEMENT_2);

        assertThat(list.get(0)).isEqualTo(ELEMENT_2);
    }

    @Test
    void shouldAddAtIndex() {
        MyArrayList<String> list = initList();
        int index = 2;

        list.add(ELEMENT_2, index);

        assertThat(list.get(index)).isEqualTo(ELEMENT_2);
    }

    @Test
    void shouldNotAddElementWhenIndexIsOutOfBounds() {
        int index = 8;

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> new MyArrayList<String>().add(ELEMENT_1, index)
        );
    }

    @Test
    void shouldDeleteElement() {
        MyArrayList<String> list = initList();
        list.add(ELEMENT_2, 2);

        list.delete(ELEMENT_2);

        assertThat(list.contains(ELEMENT_2)).isFalse();
        assertThat(list.getSize()).isEqualTo(3);
    }

    @Test
    void shouldNotDeleteElementOutOfRange() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add(ELEMENT_1);
        list.add(ELEMENT_2);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> new MyArrayList<String>().delete(3)
        );
    }

    @Test
    void shouldGiveElementByIndex() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add(ELEMENT_1);

        assertThat(list.get(0)).isEqualTo(ELEMENT_1);
    }

    @Test
    void shouldNotGiveElementOutOfRange() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add(ELEMENT_1);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> new MyArrayList<String>().get(1)
        );
    }

    @Test
    void shouldIterate() {
        MyArrayList<String> list = initList();
        list.add(ELEMENT_2, 1);
        Iterator<String> iterator = list.iterator();

        assertThat(iterator.next()).isEqualTo(ELEMENT_1);
        assertThat(iterator.next()).isEqualTo(ELEMENT_2);
        assertThat(iterator.next()).isEqualTo(ELEMENT_1);
        assertThat(iterator.next()).isEqualTo(ELEMENT_1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 50, 100})
    void shouldAddElementsOverInitialCapacity(int size) {
        MyArrayList<String> list = new MyArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(ELEMENT_1);
        }

        assertThat(list.getSize()).isEqualTo(size);
    }

    private MyArrayList<String> initList() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add(ELEMENT_1);
        list.add(ELEMENT_1);
        list.add(ELEMENT_1);

        return list;
    }
}