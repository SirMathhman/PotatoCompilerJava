package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public interface Matcher {
    Optional<Match> build(LexerState lexerState);
}
