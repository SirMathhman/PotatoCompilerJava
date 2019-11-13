package com.meti.lexeme;

public class SimpleDepth implements Depth {
    private int depth = 0;

    @Override
    public int value() {
        return depth;
    }

    @Override
    public void sink() {
        depth++;
    }

    @Override
    public void surface() {
        depth--;
    }
}