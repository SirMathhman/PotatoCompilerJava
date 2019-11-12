package com.meti.lexeme.match.struct;

import com.meti.lexeme.LexerState;
import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

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
