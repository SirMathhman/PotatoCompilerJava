package com.meti.interpret.statement;

public interface Assignment extends Statement {
    Declaration variable();

    Statement value();
}
