package de.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Task3Test {
    @Test
    void sumBig() {
        ArrayList<Integer> b = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            b.add(i * i);
        }

        Assertions.assertThrows(ArithmeticException.class, () -> {
            Task3.sum(b);
        });
    }

    @Test
    void sumSmall() {
        ArrayList<Integer> b = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            b.add(i * i);
        }

        int foo = Task3.sum(b);
        Assertions.assertTrue(foo > 0);
    }
}