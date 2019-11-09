package com.meti.lexeme;

import com.meti.lexeme.match.Matcher;
import com.meti.lexeme.match.OperatorMatcher;
import com.meti.lexeme.match.VariableMatcher;

import java.util.List;

public final class PotatoLexer extends SequentialLexer {
	public static final Lexer INSTANCE = new PotatoLexer(List.of(
			new OperatorMatcher(),
			new VariableMatcher()
	));

	private PotatoLexer(List<? extends Matcher> builders) {
		super(builders);
	}
}
