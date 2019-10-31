package com.meti;

import java.util.Optional;

interface LexerState {
    Optional<LexerState> parent();

    Optional<Lexeme> value();
}
