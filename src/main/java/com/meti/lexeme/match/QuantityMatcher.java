package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class QuantityMatcher implements Matcher{
	@Override
	public Optional<Match<?>> build(LexerState state) {
		var value = state.compute();
		if(value.equals("(") || value.equals(")")) {
			return Optional.of(new QuantityMatch(value.equals("(")));
		}
		return Optional.empty();
	}
}
