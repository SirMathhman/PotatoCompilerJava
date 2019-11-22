package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

public class IntegerTokenizer implements Tokenizer<Integer> {
    @Override
    public Optional<? extends Token<Integer>> match(LexerInput input) {
        var trailing = input.trailing();
        if ((trailing.isEmpty() || !Character.isDigit(trailing.get())) &&
                input.compute().chars().allMatch(Character::isDigit)) {
            return Optional.of(new InlineToken<>(TokenType.INT, Integer.parseInt(input.compute())));
        } else {
            return Optional.empty();
        }
    }
}
