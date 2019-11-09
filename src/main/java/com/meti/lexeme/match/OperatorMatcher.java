package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public class OperatorMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		return Arrays.stream(Operator.values())
				.filter(operator -> operator.value().equals(state.compute()))
				.map((Function<Operator, Match<?>>) OperatorMatch::new)
				.findAny();
	}
}
