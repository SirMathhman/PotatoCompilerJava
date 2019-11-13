package com.meti.interpret.statement;

import java.util.function.Predicate;

public class ReturnStatement implements Statement {
    private Statement value;

    public ReturnStatement(Statement value) {
        this.value = value;
    }

    @Override
    public void replaceAll(Predicate<? super Statement> test, Statement replacement) {
        if(test.test(value)) value = replacement;
        value.replaceAll(test, replacement);
    }

    public Statement value() {
        return value;
    }
}
