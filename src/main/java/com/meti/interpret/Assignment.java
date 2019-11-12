package com.meti.interpret;

public interface Assignment extends Statement {
    Variable variable();

    Statement value();
}
