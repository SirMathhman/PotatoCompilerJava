package com.meti.lex.token;

public class InlineToken<T> implements Token<T> {
    private final T value;
    private final TokenType type;

    public InlineToken(TokenType type) {
        this(null, type);
    }

    public InlineToken(T value, TokenType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public TokenType type() {
        return type;
    }

    @Override
    public T value() {
        return value;
    }
}
