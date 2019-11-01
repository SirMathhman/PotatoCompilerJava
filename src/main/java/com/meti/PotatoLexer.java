package com.meti;

import java.util.List;

class PotatoLexer extends SequentialLexer {
	public static final Lexer PotatoLexer = new PotatoLexer(List.of(
			new ArgumentMatcher(),
			new BlockMatcher(),
			new KeywordMatcher(),
			new NameMatcher(),
			new InvalidMatcher()));

	private PotatoLexer(List<? extends Matcher> builders) {
		super(builders);
	}
}
