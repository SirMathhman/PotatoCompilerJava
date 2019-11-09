package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class VariableMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		var value = state.compute();
		switch (value) {
			case "var":
				return Optional.of(new VariableMatch(true));
			case "val":
				return Optional.of(new VariableMatch(false));
			default:
				return Optional.empty();
		}
	}
}
