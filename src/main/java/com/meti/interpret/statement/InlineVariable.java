package com.meti.interpret.statement;

import java.util.function.Predicate;

public class InlineVariable implements Variable {
    private final String name;

    public InlineVariable(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void replaceAll(Predicate<? super Statement> test, Statement replacement) {

    }
}
