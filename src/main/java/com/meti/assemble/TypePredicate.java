package com.meti.assemble;

import com.meti.token.Token;
import com.meti.token.TokenType;

import java.util.function.Predicate;

class TypePredicate implements Predicate<Token<?>> {
    private final TokenType type;

    private TypePredicate(TokenType type) {
        this.type = type;
    }

    static Predicate<Token<?>> anyType() {
        return token -> true;
    }

    static TypePredicate type(TokenType type) {
        return new TypePredicate(type);
    }

    @Override
    public boolean test(Token<?> token) {
        return token.type().equals(type);
    }
}
