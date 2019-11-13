package com.meti.lexeme;

import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;
import com.meti.util.DoCollector;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SequentialLexer implements Lexer {
    private final List<? extends Matcher> matchers;

    SequentialLexer(List<? extends Matcher> matchers) {
        this.matchers = matchers;
    }

    @Override
    public List<? extends Match<?>> parse(String value) {
        var state = new StringState(value);
        var collector = new DoCollector<Optional<Match<?>>>(state::canParseMore);
        return collector.collect(() -> matchNext(state))
                .stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
    }

    private Optional<Match<?>> matchNext(LexerState state) {
        var match = match(state);
        if (match.isPresent()) state.advance().skipWhitespace();
        else state.extend();
        return match;
    }

    private Optional<Match<?>> match(LexerState state) {
        return matchers.stream()
                .map(matcher -> matcher.build(state))
                .flatMap(Optional::stream)
                .findAny();
    }
}