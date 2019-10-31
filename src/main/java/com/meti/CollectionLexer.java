package com.meti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class CollectionLexer implements Lexer {
    private final Collection<? extends LexemeBuilder> builders;

    CollectionLexer(Collection<? extends LexemeBuilder> builders) {
        this.builders = builders;
    }

    @Override
    public Collection<? extends Lexeme> parse(String value) {
        LexerState state = new EmptyLexerState(value);
        for (LexemeBuilder builder : builders) {
            if (builder.canBuild(state)) state = builder.build(state);
        }

        List<Lexeme> lexemes = new ArrayList<>();
        appendToList(lexemes, state);
        return lexemes;
    }

    private void appendToList(List<Lexeme> lexemes, LexerState state) {
        state.value().ifPresent((Lexeme lexeme) -> lexemes.add(0, lexeme));
        state.parent().ifPresent((LexerState parent) -> appendToList(lexemes, parent));
    }
}
