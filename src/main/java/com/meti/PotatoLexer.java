package com.meti;

import scala.collection.Seq;

import java.util.List;

class PotatoLexer extends SequentialLexer {
	public static final Lexer PotatoLexer = new PotatoLexer(List.of(
			new ArgumentTokenBuilder(),
			new BlockTokenBuilder(),
			new KeywordTokenBuilder(),
			new NameTokenBuilder(),
			new InvalidTokenBuilder()));

	private PotatoLexer(List<? extends TokenBuilder> builders) {
		super(builders);
	}
}
