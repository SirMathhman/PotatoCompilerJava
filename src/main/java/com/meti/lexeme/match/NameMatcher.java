package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class NameMatcher implements Matcher {
	@Override
	public Optional<Match> build(LexerState lexerState) {
		return lexerState.trailing(1).equals("[") ||
				lexerState.trailing(1).equals(".") ||
				lexerState.trailing(1).equals("(") ||
				lexerState.trailing(1).equals("=") ?
				Optional.of(new InlineMatch(lexerState.compute()
						.trim()
						.replace(".", ""))) :
				Optional.empty();
	}
}
