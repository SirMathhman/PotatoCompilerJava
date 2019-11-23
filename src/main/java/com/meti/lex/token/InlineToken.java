package com.meti.lex.token;

public class InlineToken<T> implements Token<T> {
    private final T value;
    private final TokenType type;

    public InlineToken(TokenType type) {
        this(type, null);
    }

    @Override
    public String toString() {
        return "InlineToken{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }

    public InlineToken(TokenType type, T value) {
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
