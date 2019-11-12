package com.meti.lexeme;

import com.meti.lexeme.match.Matcher;
import com.meti.lexeme.match.format.ContentMatcher;
import com.meti.lexeme.match.format.ListMatcher;
import com.meti.lexeme.match.format.QuantityMatcher;
import com.meti.lexeme.match.format.SeparatorMatcher;
import com.meti.lexeme.match.primitive.BooleanMatcher;
import com.meti.lexeme.match.primitive.IntegerMatcher;
import com.meti.lexeme.match.primitive.StringMatcher;
import com.meti.lexeme.match.struct.*;

import java.util.List;

public final class PotatoLexer extends SequentialLexer {
	public static final Lexer INSTANCE = new PotatoLexer(List.of(
			new SeparatorMatcher(),
			new ArgumentMatcher(),
			new OperatorMatcher(),
			new VariableMatcher(),
			new QuantityMatcher(),
			new BooleanMatcher(),
			new EndLineMatcher(),
			new GenericMatcher(),
			new IntegerMatcher(),
			new KeywordMatcher(),
			new StringMatcher(),
			new BlockMatcher(),
			new ChildMatcher(),
			new ListMatcher(),
			new ContentMatcher()
	));

	private PotatoLexer(List<? extends Matcher> builders) {
		super(builders);
	}
}
