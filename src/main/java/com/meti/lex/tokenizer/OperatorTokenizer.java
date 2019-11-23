package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OperatorTokenizer implements Tokenizer<Valued<Character>> {
	private final Map<Character, Valued<Character>> map = Arrays.stream(Operator.values())
			.collect(Collectors.toMap(Valued::value, Function.identity()));

	@Override
	public Optional<? extends Token<Valued<Character>>> match(LexerInput input) {
		return input.compute().length() == 1 ?
				Optional.ofNullable(map.get(input.compute().charAt(0))).map(mutable -> new InlineToken<>(TokenType.OPERATOR, mutable)) :
				Optional.empty();
	}
}
