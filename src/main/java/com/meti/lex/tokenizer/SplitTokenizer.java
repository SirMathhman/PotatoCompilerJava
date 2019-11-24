package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

public class SplitTokenizer implements Tokenizer<Integer> {
    private final Binding<Integer> depth;

    public SplitTokenizer(Binding<Integer> depth) {
        this.depth = depth;
    }

    @Override
    public Optional<? extends Token<Integer>> match(LexerInput input) {
        return Optional.<Token<Integer>>of(new InlineToken<>(TokenType.SPLIT, depth.get()))
                .filter(objectInlineToken -> input.compute().equals(";"));
    }
}
