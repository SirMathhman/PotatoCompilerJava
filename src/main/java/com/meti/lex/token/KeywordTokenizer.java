package com.meti.lex.token;

import com.meti.lex.LexerInput;

import java.util.Arrays;
import java.util.Optional;

class KeywordTokenizer implements Tokenizer {
    @Override
    public Optional<? extends Token> match(LexerInput input) {
        var value = input.compute();
        return Arrays.stream(Keyword.values())
                .filter(keyword -> keyword.value().equals(value))
                .findAny()
                .map(keyword -> new InlineToken<>(keyword, TokenType.KEYWORD));
    }
}
