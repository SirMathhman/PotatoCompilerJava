package com.meti.token;

class InlineToken<T> implements Token<T> {
    private final T mutable;
    private final TokenType type;

    InlineToken(T mutable, TokenType type) {
        this.mutable = mutable;
		this.type = type;
    }

    @Override
    public TokenType type() {
        return type;
    }

    @Override
    public T value() {
        return mutable;
    }
}
