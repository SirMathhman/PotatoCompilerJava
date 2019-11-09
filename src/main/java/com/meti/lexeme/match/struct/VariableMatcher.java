package com.meti.lexeme.match.struct;

import com.meti.lexeme.LexerState;
import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

import java.util.Optional;

public class VariableMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		var value = state.compute();
		var trailing = state.trailing();
		if (trailing.isPresent() && trailing.get() != ' ') return Optional.empty();
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
