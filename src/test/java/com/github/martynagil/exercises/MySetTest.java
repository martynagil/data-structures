package com.github.martynagil.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MySetTest {

    private static final String ELEMENT = "String";
    private static final String ITEM = "Item";

    @Test
    void shouldStoreOneElementOfKind() {
        MySet<String> set = new MySet<>();

        set.add(ELEMENT);
        set.add(ELEMENT);
        set.add(ITEM);

        int counter = 0;

        for (int i = 0; i < set.getSize(); i++) {
            if (set.getElement(i).equals(ELEMENT)) {
                counter++;
            }
        }

        assertEquals(1, counter);
    }

    @Test
    void shouldAddElement() {
        MySet<String> set = new MySet<>();

        set.add(ELEMENT);
        set.add(ITEM);

        assertThat(set.contains(ITEM)).isEqualTo(true);
    }

    @Test
    void shouldDeleteElement() {
        MySet<String> set = new MySet<>();

        set.add(ITEM);
        set.add(ELEMENT);
        set.delete(ELEMENT);

        assertThat(set.contains(ELEMENT)).isFalse();
    }

    @Test
    void shouldNotDeleteElement() {
        MySet<String> set = new MySet<>();

        set.add(ELEMENT);
        set.delete(ITEM);

        assertThat(set.getSize()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 50, 100})
    void shouldExtendProperly(int ints) {
        MySet<String> set = new MySet<>();

        for (int i = 0; i < ints; i++) {
            set.add(ELEMENT + i);
        }

        assertThat(set.getSize()).isEqualTo(ints);
    }
}

