package com.meti.lex.token;

import com.meti.lex.LexerInput;

import java.util.Optional;

public class SplitTokenizer implements Tokenizer<Void> {
    @Override
    public Optional<? extends Token<Void>> match(LexerInput input) {
        return Optional.<Token<Void>>of(new InlineToken<>(TokenType.SPLIT))
                .filter(objectInlineToken -> input.compute().equals(";"));
    }
}
