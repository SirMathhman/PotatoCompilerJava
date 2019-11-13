package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public interface Matcher {
    Optional<Match<?>> build(LexerState state);

    default <T extends Match<?>> Optional<T> build(LexerState state, Class<T> clazz) {
        var result = build(state);
        try {
            return Optional.ofNullable(clazz.cast(result));
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }
}
