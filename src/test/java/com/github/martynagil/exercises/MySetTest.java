package com.github.martynagil.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MySetTest {

    private static final String ELEMENT_1 = "String";
    private static final String ELEMENT_2 = "Item";

    @Test
    void shouldStoreOneElementOfKind() {
        MySet<String> set = new MySet<>();

        set.add(ELEMENT_1);
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);

        int counter = 0;

        for (int i = 0; i < set.getSize(); i++) {
            if (set.getElement(i).equals(ELEMENT_1)) {
                counter++;
            }
        }

        assertEquals(1, counter);
    }

    @Test
    void shouldAddElement() {
        MySet<String> set = new MySet<>();

        set.add(ELEMENT_1);
        set.add(ELEMENT_2);

        assertThat(set.contains(ELEMENT_2)).isEqualTo(true);
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

    @ParameterizedTest
    @ValueSource(ints = {2, 50, 100})
    void shouldExtendProperly(int ints) {
        MySet<String> set = new MySet<>();

        for (int i = 0; i < ints; i++) {
            set.add(ELEMENT_1 + i);
        }

        assertThat(set.getSize()).isEqualTo(ints);
    }
}

