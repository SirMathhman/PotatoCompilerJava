package com.meti.lexeme.match.format;

import com.meti.lexeme.LexerState;
import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

import java.util.Optional;

public class ListMatcher implements Matcher {
    @Override
    public Optional<Match<?>> build(LexerState state) {
        var value = state.compute();
        return value.equals("[") || value.equals("]") ?
                Optional.of(new ListMatch(value.equals("["))) :
				Optional.empty();
    }
}
