package com.meti.util;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoCollectorTest {
    private int counter = 0;

    @Test
    void collect() {
        var collector = new DoCollector<Integer>(this::condition);
        var list = collector.collect(this::value);
        assertEquals(List.of(0, 1, 2, 3, 4), list);
    }

    private Integer value() {
        return counter++;
    }

    private Boolean condition() {
        return counter < 5;
    }
}