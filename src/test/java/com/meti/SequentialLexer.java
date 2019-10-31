package com.meti;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SequentialLexer implements Lexer {
    private final List<? extends TokenBuilder> builders;

    SequentialLexer(List<TokenBuilder> builders) {
        this.builders = builders;
    }

    @Override
    public List<? extends Token> parse(String value) {
        int beginning = 0;
        int end = 1;
        List<Token> tokens = new ArrayList<>();
        do {
            Token token = null;
            String subValue = value.substring(beginning, end);
            for (TokenBuilder builder : builders) {
                Optional<Token> optional = builder.build(subValue);
                if (optional.isPresent()) {
                    token = optional.get();
                }
            }
            tokens.add(token);
            if (token == null) {
                end++;
            } else {
                beginning = end;
                end = beginning + 1;
            }
        } while (beginning != value.length());

        return tokens;
    }
}