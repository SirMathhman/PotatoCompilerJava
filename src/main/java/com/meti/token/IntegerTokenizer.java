package com.meti.token;

import com.meti.lex.LexerInput;

import java.util.Optional;

public class IntegerTokenizer implements Tokenizer<Integer> {
    @Override
    public Optional<? extends Token<Integer>> match(LexerInput input) {
        var trailing = input.trailing();
        if ((trailing.isEmpty() || !Character.isDigit(trailing.get())) &&
                input.compute().chars().allMatch(Character::isDigit)) {
            return Optional.of(new InlineToken<>(Integer.parseInt(input.compute()), TokenType.INTEGER));
        } else {
            return Optional.empty();
        }
    }
}
