package com.meti.lexeme.match.format;

import com.meti.lexeme.StringState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContentMatcherTest {

    @Test
    void build() {
        var state = new StringState("stuff");
        var matcher = new ContentMatcher();
        var result = matcher.build(state);
        assertTrue(result.isPresent());
        assertEquals("stuff", result.get().value());
    }
}