package com.meti.lex.token;

import com.meti.lex.Lexer;
import com.meti.lex.tokenizer.*;

public class PotatoLexer extends TokenLexer {
	private static final Binding<Integer> depth = new Binding<>(0);
	public static final Lexer<Token<?>> INSTANCE = new PotatoLexer(
			new BracketTokenizer(depth),
			new DeclareTokenizer(),
			new IntegerTokenizer(),
			new KeywordTokenizer(),
			new ListTokenizer(),
			new OperatorTokenizer(),
			new ParenthesisTokenizer(),
			new EntryTokenizer(),
			new SplitTokenizer(depth),
			new ContentTokenizer()
	);

	private PotatoLexer(Tokenizer<?>... tokenizers) {
		super(tokenizers);
	}
}
