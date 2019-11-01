package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class BlockMatcher implements Matcher {
	@Override
	public Optional<Match> build(LexerState lexerState) {
		Optional<Match> result;
		String value = lexerState.compute();
		if (value.equals("={")) {
			result = Optional.of(new BlockMatch());
		} else if (value.equals("}")) {
			result = Optional.of(new BlockMatch());
		} else {
			result = Optional.empty();
		}
		return result;
	}
}
