package com.meti;

import java.util.Optional;

interface Matcher {
    Optional<Match> build(LexerState lexerState);
}
