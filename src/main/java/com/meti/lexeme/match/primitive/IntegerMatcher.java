package com.meti.lexeme.match.primitive;

import com.meti.lexeme.LexerState;
import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

import java.util.Optional;

public class IntegerMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		var trailing = state.trailing();
		if (trailing.isPresent() && Character.isDigit(trailing.get())) {
			return Optional.empty();
		} else {
			try {
				return Optional.of(new IntegerMatch(Integer.parseInt(state.compute())));
			} catch (NumberFormatException e) {
				return Optional.empty();
			}
		}
	}
}
