package com.meti.lexeme.match.struct;

import com.meti.lexeme.LexerState;
import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

import java.util.Optional;

public class KeywordMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		var value = state.compute().toUpperCase();
		try {
			return Optional.of(new KeywordMatch(Keyword.valueOf(value)));
		} catch (IllegalArgumentException e) {
			return Optional.empty();
		}
	}
}
