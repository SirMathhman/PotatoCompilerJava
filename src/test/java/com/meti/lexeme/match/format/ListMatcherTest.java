package com.meti.lexeme.match.format;

import com.meti.lexeme.StringState;
import com.meti.lexeme.match.Match;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class ListMatcherTest {
    @Test
    void buildClosing(){
        var state = new StringState("]");
        var matcher = new ListMatcher();
        var result = matcher.build(state, ListMatch.class);
        assertTrue(result.isPresent());
        assertFalse(result.get().value());
    }

    @Test
    void buildInvalid(){
        var state = new StringState("t");
        var matcher = new ListMatcher();
        var result = matcher.build(state, ListMatch.class);
        assertTrue(result.isEmpty());
    }

    @Test
    void buildOpening() {
        var state = new StringState("[");
        var matcher = new ListMatcher();
        var result = matcher.build(state, ListMatch.class);
        assertTrue(result.isPresent());
        assertTrue(result.get().value());
    }
}