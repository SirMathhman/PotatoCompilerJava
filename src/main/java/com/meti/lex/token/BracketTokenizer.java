package com.meti.lex.token;

import com.meti.lex.LexerInput;

import java.util.Optional;

public class BracketTokenizer implements Tokenizer<Boolean> {
    @Override
    public Optional<? extends Token<Boolean>> match(LexerInput input) {
        return Optional.of(input.compute())
                .filter(s -> s.equals("{") || s.equals("}"))
                .map(s -> s.equals("{"))
                .map(aBoolean -> new InlineToken<>(TokenType.BRACKET, aBoolean));
    }
}
