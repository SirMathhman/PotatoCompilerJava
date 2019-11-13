package com.meti.lexeme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringStateTest {

    @Test
    void advance() {
        var result = new StringState("test")
                .advance()
                .compute();
        assertEquals("te", result);
    }

    @Test
    void compute() {
        var result = new StringState("test")
                .compute();
        assertEquals("t", result);
    }

    @Test
    void depth() {
        var state = new StringState("");
        var depth = state.depth();
        var depthValue = depth.value();
        assertEquals(0, depthValue);
    }

    @Test
    void hasMoreCharactersSingle() {
        var canParseMore = new StringState("t")
                .reset()
                .canParseMore();
        assertFalse(canParseMore);
    }

    @Test
    void hasMoreCharactersMultiple(){
        var canParseMore = new StringState("test")
                .reset()
                .reset()
                .reset()
                .reset()
                .canParseMore();
        assertFalse(canParseMore);
    }

    @Test
    void reset() {
        var result = new StringState("test")
                .reset()
                .compute();
        assertEquals("e", result);
    }

    @Test
    void skipWhitespace() {
        var result = new StringState("  foo")
                .skipWhitespace()
                .compute();
        assertEquals("f", result);
    }

    @Test
    void trailing() {
        var result = new StringState("test")
                .trailing(3);
        assertEquals("est", result);
    }

    @Test
    void testTrailing() {
        var result = new StringState("t")
                .trailing()
                .isEmpty();
        assertTrue(result);
    }
}