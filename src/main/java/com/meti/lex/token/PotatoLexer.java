package com.meti.lex.token;

import com.meti.lex.Lexer;
import com.meti.lex.tokenizer.*;

public class PotatoLexer extends TokenLexer {
	public static final Lexer<Token<?>> INSTANCE = new PotatoLexer(
			new BracketTokenizer(),
			new ContentTokenizer(),
			new DeclareTokenizer(),
			new IntegerTokenizer(),
			new KeywordTokenizer(),
			new ListTokenizer(),
			new OperatorTokenizer(),
			new ParenthesisTokenizer(),
			new SplitTokenizer()
	);

	private PotatoLexer(Tokenizer<?>... tokenizers) {
		super(tokenizers);
	}
}
