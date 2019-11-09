package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class VariableMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState lexerState) {
		var value = lexerState.compute();
		if(value.equals("var")) return Optional.of(new VariableMatch(true));
		else if(value.equals("val")) return Optional.of(new VariableMatch(false));
		return Optional.empty();
	}
}
