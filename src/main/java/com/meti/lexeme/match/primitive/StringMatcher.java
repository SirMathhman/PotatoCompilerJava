package com.meti.lexeme.match.primitive;

import com.meti.lexeme.LexerState;
import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

import java.util.Optional;

public class StringMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		var value = state.compute();
		if(value.equals("\"")) return Optional.empty();
		if(value.charAt(0) == '\"' && value.charAt(value.length() - 1) == '\"')
			return Optional.of(new StringMatch(value.substring(1, value.length() - 1)));
		return Optional.empty();
	}
}
