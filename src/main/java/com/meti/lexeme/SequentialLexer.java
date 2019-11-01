package com.meti.lexeme;

import com.meti.lexeme.match.Match;
import com.meti.lexeme.match.Matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class SequentialLexer implements Lexer {
	private final List<? extends Matcher> builders;

	SequentialLexer(List<? extends Matcher> builders) {
		this.builders = builders;
	}

	@Override
	public List<? extends Match> parse(String value) {
		LexerState state = new SimpleLexerState(value);
		List<Match> matches = new ArrayList<>();
		boolean shouldContinue;
		do {
			shouldContinue = buildNextToken(state, matches);
		} while (shouldContinue);
		return matches;
	}

	private boolean buildNextToken(LexerState state, Collection<? super Match> tokens) {
		builders.stream()
				.map(builder -> builder.build(state))
				.flatMap(Optional::stream)
				.findAny()
				.ifPresentOrElse(token -> {
					state.reset();
					tokens.add(token);
				}, state::advance);
		return state.hasMoreCharacters();
	}
}