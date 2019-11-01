package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class InvocationMatcher implements Matcher {
	@Override
	public Optional<Match> build(LexerState lexerState) {
		var value = lexerState.compute();
		return value.equals("(") || value.equals(")") ?
				Optional.of(new InvocationMatch(value.equals("("))) :
				Optional.empty();
	}
}
