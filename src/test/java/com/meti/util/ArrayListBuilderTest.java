package com.meti.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListBuilderTest {

    @Test
    void appendVarArgs() {
        var actual = new ArrayListBuilder<String>()
                .append("some")
                .build();
        var expected = singleton("some");
        assertIterableEquals(expected, actual);
    }

    @Test
    void appendList() {
        var expected = singleton("some");
        var actual = new ArrayListBuilder<String>()
                .append(expected)
                .build();
        assertIterableEquals(expected, actual);
    }

    @Test
    void build() {
        var list = new ArrayList<>();
        var builder = new ArrayListBuilder<>(list);
        assertEquals(list, builder.build());
    }
}