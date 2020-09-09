package com.github.martynagil.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyArrayListTest {

    String element = "String";

    @Test
    void shouldCreateArrayWithProperLength() {
        MyArrayList<String> list1 = new MyArrayList<>();
        int length = 8;
        MyArrayList<String> list2 = new MyArrayList<>(length);
        int list1Size = 0;
        int list2Size = 0;
        Iterator<String> iterator1 = list1.iterator();
        Iterator<String> iterator2 = list2.iterator();

        while (iterator1.hasNext()) {
            list1Size++;
            iterator1.next();
        }

        while (iterator2.hasNext()) {
            list2Size++;
            iterator2.next();
        }

        assertThat(list1Size).isEqualTo(6);
        assertThat(list2Size).isEqualTo(length);
    }

    @Test
    void shouldAdd() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(element);

        assertThat(list.getLastElement()).isEqualTo(element);
    }

    @Test
    void shouldAddAtTheBeginning() {
        MyArrayList<String> list = new MyArrayList<>();

        list.addAtBeginning(element);

        assertThat(list.getElement(0)).isEqualTo(element);
    }

    @Test
    void shouldAddAtIndex() {
        MyArrayList<String> list = new MyArrayList<>();
        int index = 0;

        list.addAtIndex(element, index);

        assertThat(list.getElement(index)).isEqualTo(element);
    }

    @Test
    void shouldNotAdd() {
        int index = 8;

        assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().addAtIndex(element, index));
    }

    @Test
    void shouldDelete() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(element);
        list.deleteElement(element);

        assertThat(list.containElement(element)).isFalse();
    }

    @Test
    void shouldNotDelete() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(element);

        assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().deleteAtIndex(1));
    }

    @Test
    void shouldGiveElementByIndex() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(element);

        assertThat(list.getElement(0)).isEqualTo(element);
    }

    @Test
    void shouldNotGiveElementByIndex() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add(element);

        assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().getElement(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 50, 100})
    void shouldActProperly(int ints) {
        MyArrayList<String> list = new MyArrayList<>();

        for (int i = 0; i < ints; i++) {
            list.add("word");
        }

        assertThat(list.size()).isEqualTo(ints);
    }
}