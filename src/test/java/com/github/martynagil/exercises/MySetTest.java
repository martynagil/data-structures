package com.github.martynagil.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

class MySetTest {

    private static final String ELEMENT_1 = "String";
    private static final String ELEMENT_2 = "Item";

    @Test
    void shouldStoreOneElementOfKind() {
        MySet<String> set = new MySet<>();

        set.add(ELEMENT_1);
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);

        assertThat(set.getSize()).isEqualTo(2);
        assertThat(set.contains(ELEMENT_1)).isTrue();
        assertThat(set.contains(ELEMENT_2)).isTrue();
    }

    @Test
    void shouldAddElement() {
        MySet<String> set = new MySet<>();

        set.add(ELEMENT_1);
        set.add(ELEMENT_2);

        assertThat(set.contains(ELEMENT_2)).isTrue();
        assertThat(set.getSize()).isEqualTo(2);
    }

    @Test
    void shouldDeleteElement() {
        MySet<String> set = new MySet<>();
        set.add(ELEMENT_2);
        set.add(ELEMENT_1);

        set.delete(ELEMENT_1);

        assertThat(set.contains(ELEMENT_1)).isFalse();
        assertThat(set.getSize()).isEqualTo(1);
    }

    @Test
    void shouldNotDeleteElement() {
        MySet<String> set = new MySet<>();
        set.add(ELEMENT_1);

        set.delete(ELEMENT_2);

        assertThat(set.getSize()).isEqualTo(1);
        assertThat((set.contains(ELEMENT_1))).isTrue();
    }

    @Test
    void shouldMakeProperIterations() {
        MySet<String> set = new MySet<>();
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);
        Iterator<String> iterator = set.iterator();

        assertThat(iterator.next()).isEqualTo(ELEMENT_1);
        assertThat(iterator.next()).isEqualTo(ELEMENT_2);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 50, 100})
    void shouldExtendProperly(int size) {
        MySet<String> set = new MySet<>();

        for (int i = 0; i < size; i++) {
            set.add(ELEMENT_1 + i);
        }

        assertThat(set.getSize()).isEqualTo(size);
    }
}

