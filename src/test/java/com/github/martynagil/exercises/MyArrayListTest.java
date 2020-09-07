package com.github.martynagil.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    MyArrayList<String> list = new MyArrayList<>();

    @Test
    void shouldCreateArrayWithProperLength() {
        MyArrayList<String> list1 = new MyArrayList<>();
        int length = 8;
        MyArrayList<String> list2 = new MyArrayList<>(length);

        assertThat(list1.size()).isEqualTo(6);
        assertThat(list2.size()).isEqualTo(length);
    }

    @Test
    void shouldAdd() {
        String element = "Something";

        list.add(element);

        assertThat(list.getLastElement()).isEqualTo(element);
    }

    @Test
    void shouldAddAtTheBeginning() {
        String element = "Anything";

        list.addAtBeginning(element);

        assertThat(list.getElement(0)).isEqualTo(element);
    }

    @Test
    void shouldAddAtIndex() {
        String element = "Whatever";
        int index = 4;

        list.addAtIndex(element, index);

        assertThat(list.getElement(index)).isEqualTo(element);
    }

    @Test
    void shouldNotAdd() {
        String element = "Whatsoever"
        int index = 8;


        assertThrows(IndexOutOfBoundsException.class, list.addAtIndex(element, index));

        // TODO: 08.09.2020  
    }
}