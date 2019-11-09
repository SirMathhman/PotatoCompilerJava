package com.meti.lexeme.match.primitive;

import com.meti.lexeme.LexerState;
import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

import java.util.Optional;

public class ArrayMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		var value = state.compute();
		if(value.equals("[") || value.equals("]")) {
			return Optional.of(new ArrayMatch(value.equals("[")));
		}
		return Optional.empty();
	}
}
