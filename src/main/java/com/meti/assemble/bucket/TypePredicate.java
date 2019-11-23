package com.meti.assemble.bucket;

import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.function.Predicate;

public class TypePredicate implements Predicate<Token<?>> {
    private final TokenType type;

    private TypePredicate(TokenType type) {
        this.type = type;
    }

    public static Predicate<Token<?>> any() {
        return token -> true;
    }

    public static TypePredicate type(TokenType type) {
        return new TypePredicate(type);
    }

    @Override
    public boolean test(Token<?> token) {
        return token.type().equals(type);
    }
}
