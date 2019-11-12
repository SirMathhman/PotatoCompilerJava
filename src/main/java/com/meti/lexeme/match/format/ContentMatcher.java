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
	private static final Set<String> trailing = new HashSet<>();

	static {
		trailing.addAll(Set.of(";", " ", "{", "[", ",", "]", ".", "(", ")", "}"));
		trailing.addAll(Arrays.stream(Operator.values())
				.map(Operator::value)
				.collect(Collectors.toSet()));
	}

	@Override
	public Optional<Match<?>> build(LexerState state) {
		var value = state.compute();
		return (doesNotStartWithChars(value) || (state.trailing().isPresent() && hasValidTrail(state))) ?
				Optional.empty() : Optional.of(new ContentMatch(value));
	}

	private boolean doesNotStartWithChars(String value) {
		return !value.isEmpty() && (value.charAt(0) == '\"' || value.charAt(0) == '.');
	}

	private boolean hasValidTrail(LexerState state) {
		return trailing.stream().noneMatch(s -> state.trailing(1).equals(s));
	}
}
