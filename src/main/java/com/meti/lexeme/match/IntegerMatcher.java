package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class IntegerMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		if(!Character.isDigit(state.trailing())){
			try {
				return Optional.of(new IntegerMatch(Integer.parseInt(state.compute())));
			} catch (NumberFormatException e) {
				return Optional.empty();
			}
		} else {
			return Optional.empty();
		}
	}
}
