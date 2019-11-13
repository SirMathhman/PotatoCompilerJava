package com.meti.lexeme;

public interface Depth {
    int value();

    Depth sink();

    Depth surface();
}
