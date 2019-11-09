package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class IntegerMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState lexerState) {
		if(!Character.isDigit(lexerState.trailing())){
			try {
				return Optional.of(new IntegerMatch(Integer.parseInt(lexerState.compute())));
			} catch (NumberFormatException e) {
				return Optional.empty();
			}
		} else {
			return Optional.empty();
		}
	}
}
