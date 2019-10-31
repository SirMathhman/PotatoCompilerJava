package com.meti;

interface LexemeBuilder {
    boolean canBuild(LexerState state);

    LexerState build(LexerState state);
}
