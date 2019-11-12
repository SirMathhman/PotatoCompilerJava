package com.meti.interpret.statement;

public interface Assignment extends Statement {
    Variable variable();

    Statement value();
}
