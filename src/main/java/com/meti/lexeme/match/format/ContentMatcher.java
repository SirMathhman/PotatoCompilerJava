package com.meti.lexeme.match.format;

import com.meti.lexeme.LexerState;
import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;
import com.meti.lexeme.match.struct.Operator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ContentMatcher implements Matcher {
    private static final Set<String> validTrails = new HashSet<>();

    static {
        validTrails.addAll(Set.of(";", " ", "{", "[", ",", "]", ".", "(", ")", "}", "<"));
        validTrails.addAll(Arrays.stream(Operator.values())
                .map(Operator::value)
                .collect(Collectors.toSet()));
    }

    @Override
    public Optional<Match<?>> build(LexerState state) {
        var value = state.compute();
        if (doesNotStartWithChars(value)) {
            return Optional.empty();
        } else if (state.trailing().isPresent()) {
            if (hasInvalidFinalCharacter(state)) {
				return Optional.empty();
            } else {
                return Optional.of(new ContentMatch(value));
            }
        } else {
            return Optional.of(new ContentMatch(value));
        }
    }

    private boolean doesNotStartWithChars(String value) {
        return !value.isEmpty() &&
                value.charAt(0) == '\"' ||
                value.charAt(0) == '.';
    }

    private boolean hasInvalidFinalCharacter(LexerState state) {
        return validTrails.stream()
                .noneMatch(s -> state.trailing(1).equals(s));
    }
}
