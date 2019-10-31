interface LexemeBuilder {
    boolean canBuild(LexerState state);

    Lexeme build(LexerState state);
}
