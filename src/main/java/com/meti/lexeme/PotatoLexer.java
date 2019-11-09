package com.meti.lexeme;

import com.meti.lexeme.match.*;

import java.util.List;

public class PotatoLexer extends SequentialLexer {
	public static final Lexer INSTANCE = new PotatoLexer(List.of());

	private PotatoLexer(List<? extends Matcher> builders) {
		super(builders);
	}
}
