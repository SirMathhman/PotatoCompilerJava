package com.meti.lexeme;

import com.meti.lexeme.match.*;
import com.meti.lexeme.match.format.ContentMatcher;
import com.meti.lexeme.match.format.EndLineMatcher;
import com.meti.lexeme.match.format.QuantityMatcher;
import com.meti.lexeme.match.primitive.BooleanMatcher;
import com.meti.lexeme.match.primitive.IntegerMatcher;
import com.meti.lexeme.match.primitive.StringMatcher;
import com.meti.lexeme.match.struct.OperatorMatcher;
import com.meti.lexeme.match.struct.VariableMatcher;

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
