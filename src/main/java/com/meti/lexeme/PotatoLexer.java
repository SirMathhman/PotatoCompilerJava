package com.meti.lexeme;

import com.meti.lexeme.match.*;

import java.util.List;

public class PotatoLexer extends SequentialLexer {
	public static final Lexer PotatoLexer = new PotatoLexer(List.of(
			new ArgumentMatcher(),
			new BlockMatcher(),
			new KeywordMatcher(),
			new InvocationMatcher(),
			new NameMatcher(),
			new StringMatcher(),
			new InvalidMatcher()));

	private PotatoLexer(List<? extends Matcher> builders) {
		super(builders);
	}
}
