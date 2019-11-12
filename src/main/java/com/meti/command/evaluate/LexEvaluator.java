package com.meti.command.evaluate;

import com.meti.console.Evaluator;
import com.meti.lexeme.PotatoLexer;
import com.meti.lexeme.match.Match;

import java.util.function.Function;
import java.util.stream.Collectors;

public class LexEvaluator implements Evaluator {
	@Override
	public String evaluate(String value) {
		var lexer = PotatoLexer.INSTANCE;
		if (value.isBlank()) {
			return "Nothing was entered to lexise.";
		}
		return lexer.parse(value)
				.stream()
				.map((Function<Match<?>, String>) Object::toString)
				.collect(Collectors.joining("\n"));
	}
}
