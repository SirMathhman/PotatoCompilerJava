package com.meti.lexeme;

import java.util.Optional;

public class StringState implements LexerState {
    private final String value;
    private final Depth depth = new CountedDepth();
    private int beginning = 0;
    private int end = 1;

    public StringState(String value) {
        this.value = value;
    }

    @Override
    public LexerState extend() {
        if (end == value.length()) {
            throw new IllegalStateException("Could not parse:\"" + compute() + "\"");
        } else end++;
        return this;
    }

    @Override
    public String compute() {
        return value.substring(beginning, end);
    }

    @Override
    public Depth depth() {
        return depth;
    }

    @Override
    public boolean canParseMore() {
        return beginning != value.length();
    }

    @Override
    public LexerState advance() {
        beginning = end;
        if (end != value.length()) end = beginning + 1;
        return this;
    }

    @Override
    public LexerState skipWhitespace() {
        if (beginning == value.length()) return this;
        while (value.charAt(beginning) == ' ') {
            beginning++;
            end++;
        }
        return this;
    }

    @Override
    public String trailing(int count) {
        int bound = Math.min(end + count, value.length());
        return value.substring(end, bound);
    }

    @Override
    public Optional<Character> trailing() {
        return end < value.length() ?
                Optional.of(value.charAt(end)) :
                Optional.empty();
    }
}
