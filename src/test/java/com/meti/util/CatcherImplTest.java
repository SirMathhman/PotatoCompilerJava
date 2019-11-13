package com.meti.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatcherImplTest {

    @Test
    void evaluate() {
        var result = Catcher.create()
                .evaluate(() -> 100, -1);
        assertEquals(100, result);
    }

    @Test
    void evaluateThrows() {
        var result = Catcher.create()
                .evaluate(() -> {
                    throw new IllegalStateException();
                }, 100);
        assertEquals(100, result);
    }
}