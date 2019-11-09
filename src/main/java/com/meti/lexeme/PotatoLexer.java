package com.meti.lexeme;

import com.meti.lexeme.match.*;

import java.util.List;

public final class PotatoLexer extends SequentialLexer {
	public static final Lexer INSTANCE = new PotatoLexer(List.of(
			new VariableMatcher(),
			new OperatorMatcher(),
			new QuantityMatcher(),
			new EndLineMatcher(),
			new IntegerMatcher(),
			new BooleanMatcher(),
			new StringMatcher(),
			new ContentMatcher()
	));

	private PotatoLexer(List<? extends Matcher> builders) {
		super(builders);
	}
}
