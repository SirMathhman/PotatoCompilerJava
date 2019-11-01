package com.meti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class SequentialLexer implements Lexer {
	private final List<? extends TokenBuilder> builders;

	SequentialLexer(List<? extends TokenBuilder> builders) {
		this.builders = builders;
	}

	@Override
	public List<? extends Token> parse(String value) {
		LexerState state = new SimpleLexerState(value);
		List<Token> tokens = new ArrayList<>();
		boolean shouldContinue;
		do {
			shouldContinue = buildNextToken(state, tokens);
		} while (shouldContinue);
		return tokens;
	}

	private boolean buildNextToken(LexerState state, Collection<? super Token> tokens) {
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