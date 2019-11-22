package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

public class SplitTokenizer implements Tokenizer<Void> {
    @Override
    public Optional<? extends Token<Void>> match(LexerInput input) {
        return Optional.<Token<Void>>of(new InlineToken<>(TokenType.SPLIT))
                .filter(objectInlineToken -> input.compute().equals(";"));
    }
}
