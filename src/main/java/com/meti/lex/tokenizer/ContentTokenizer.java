package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

public class ContentTokenizer implements Tokenizer<String> {
    @Override
    public Optional<? extends Token<String>> match(LexerInput input) {
        var trailing = input.trailing();
		return trailing.isPresent() && (Character.isAlphabetic(trailing.get()) || Character.isDigit(trailing.get())) ?
                Optional.empty() :
                Optional.of(new InlineToken<>(TokenType.CONTENT, input.compute()));
    }
}