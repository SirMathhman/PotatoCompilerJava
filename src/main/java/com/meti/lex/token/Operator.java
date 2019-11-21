package com.meti.lex.token;

public enum Operator implements Valued<Character> {
    ADD('+'),
	ASSIGN('=');

    private final char value;

    Operator(char value) {
        this.value = value;
    }

    @Override
    public Character value() {
        return value;
    }
}
