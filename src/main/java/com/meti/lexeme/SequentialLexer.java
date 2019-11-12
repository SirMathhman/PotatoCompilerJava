package com.meti.lexeme;

import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SequentialLexer implements Lexer {
	private final List<? extends Matcher> matchers;

	SequentialLexer(List<? extends Matcher> matchers) {
		this.matchers = matchers;
	}

	@Override
	public List<? extends Match<?>> parse(String value) {
		LexerState state = new StringLexerState(value);
		List<Match<?>> matches = new ArrayList<>();
		boolean shouldContinue;
		do {
			shouldContinue = buildNextToken(state, matches);
		} while (shouldContinue);
		return matches;
	}

	private boolean buildNextToken(LexerState state, Collection<? super Match<?>> matches) {
		Match<?> match = null;
		for (Matcher matcher : matchers) {
			var optional = matcher.build(state);
			if (optional.isPresent()) {
				match = optional.get();
				break;
			}
		}
		if (match != null) {
			state.reset();
			state.skipWhitespace();
			matches.add(match);
		} else {
			state.advance();
		}
		return state.hasMoreCharacters();
	}
}