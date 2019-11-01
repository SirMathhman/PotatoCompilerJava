package com.meti;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest2 {
	private final Lexer lexer = new SequentialLexer(List.of(
			new ArgumentTokenBuilder(),
			new BlockTokenBuilder(),
			new NameTokenBuilder(),
			new InvalidTokenBuilder()));

	@Test
	void parse(){
		String testString = "test[int value]={Internal.print(\"value\")}";
		List<? extends Token> results = lexer.parse(testString);
		assertIterableEquals(List.of(new InlineToken("test")), results);
	}
}
