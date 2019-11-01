package com.meti;

import java.util.Optional;

interface TokenBuilder {
    Optional<Token> build(LexerState lexerState);
}
