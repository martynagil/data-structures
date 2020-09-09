package com.github.martynagil.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySetTest {

    @Test
    void shouldStoreOneElementOfKind() {
        MySet<String> set = new MySet<>();
        String string = "string";

        set.add(string);
        set.add(string);
        set.add("word");

        int counter = 0;

        for (int i = 0; i < set.size(); i++) {
            if (set.getElement(i).equals(string)) {
                counter++;
            }
        }

        assertEquals(1, counter);
    }
}