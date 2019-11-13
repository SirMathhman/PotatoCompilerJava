package com.meti.interpret.statement;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ContentArray implements Statement {
    private final List< Statement> values;

    public ContentArray(List<Statement> values) {
        this.values = values;
    }

    @Override
    public void replaceAll(Predicate<? super Statement> test, Statement replacement) {
        values.stream()
                .filter(test)
                .peek(values::remove)
                .map(value -> replacement)
                .forEach(values::add);
    }

    public List<? extends Statement> values() {
        return values;
    }
}
