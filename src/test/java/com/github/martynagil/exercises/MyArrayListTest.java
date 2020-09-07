package com.github.martynagil.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

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
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Something");
// TODO: 07.09.2020  
    }
}