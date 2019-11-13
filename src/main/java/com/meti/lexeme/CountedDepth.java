package com.meti.lexeme;

public class CountedDepth implements Depth {
    private int depth = 0;

    @Override
    public int value() {
        return depth;
    }

    @Override
    public Depth sink() {
        depth++;
        return this;
    }

    @Override
    public Depth surface() {
        depth--;
        return this;
    }
}