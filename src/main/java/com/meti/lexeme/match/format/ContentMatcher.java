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
		trailing.addAll(Set.of(";", " ", "{"));
		trailing.addAll(Arrays.stream(Operator.values())
				.map(Operator::value)
				.collect(Collectors.toSet()));
	}

	@Override
	public Optional<Match<?>> build(LexerState state) {
		if(!state.compute().isEmpty() && state.compute().charAt(0) == '\"') return Optional.empty();
		if (trailing.stream().noneMatch(s -> state.trailing(1).equals(s))) {
			return Optional.empty();
		}
		return Optional.of(new ContentMatch(state.compute()));
	}
}
