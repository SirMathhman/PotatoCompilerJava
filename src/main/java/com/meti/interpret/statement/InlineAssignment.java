package com.meti.interpret.statement;

import java.util.function.Predicate;

public class InlineAssignment implements Assignment {
    private final Declaration declaration;
    private Statement value;

    public InlineAssignment(Declaration declaration, Statement value) {
        this.declaration = declaration;
        this.value = value;
    }

    @Override
    public void replaceAll(Predicate<? super Statement> test, Statement replacement) {
        if(test.test(value)) value = replacement;
    }

    @Override
    public Declaration variable() {
        return declaration;
    }

    @Override
    public String toString() {
        return "InlineAssignment{" +
                "declaration=" + declaration +
                ", value=" + value +
                '}';
    }

    @Override
    public Statement value() {
        return value;
    }
}
