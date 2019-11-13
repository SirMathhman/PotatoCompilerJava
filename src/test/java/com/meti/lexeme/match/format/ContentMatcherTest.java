package com.meti.lexeme.match.format;

import com.meti.lexeme.StringState;
import com.meti.lexeme.match.Match;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContentMatcherTest {
    @Test
    void invalidStart() {
        var state = new StringState(".stuff");
        var matcher = new ContentMatcher();
        var result = matcher.build(state);
        assertTrue(result.isEmpty());
    }

    @Test
    void invalidNext(){
        var state = new StringState("te");
        var matcher = new ContentMatcher();
        var result = matcher.build(state);
        assertTrue(result.isEmpty());
    }

    @Test
    void validWithoutTrailing () {
        var state = new StringState("t");
        var matcher = new ContentMatcher();
        var result = matcher.build(state);
        assertTrue(result.isPresent());
        assertEquals("t", result.get().value());
    }

    @Test
    void valid() {
        var state = new StringState("s;");
        var matcher = new ContentMatcher();
        var result = matcher.build(state);
        assertTrue(result.isPresent());
        assertEquals("s", result.get().value());
    }
}