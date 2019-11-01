package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class StringMatcher implements Matcher {
	@Override
	public Optional<Match> build(LexerState lexerState) {
		var value = lexerState.compute();
		if(value.length() < 2) return Optional.empty();
		return value.charAt(0) == '\"' && value.charAt(value.length() - 1) == '\"' ?
				Optional.of(new StringMatch(value.substring(1, value.length() - 1))) :
				Optional.empty();
	}
}
