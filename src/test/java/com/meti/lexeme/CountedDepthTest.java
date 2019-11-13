package com.meti.lexeme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountedDepthTest {

    @Test
    void value() {
        var value  = new CountedDepth().value();
        assertEquals(0, value);
    }

    @Test
    void sink() {
        var value = new CountedDepth()
                .sink()
                .value();
        assertEquals(1, value);
    }

    @Test
    void surface() {
        var value = new CountedDepth()
                .surface()
                .value();
        assertEquals(-1, value);
    }
}