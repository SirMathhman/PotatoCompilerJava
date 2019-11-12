package com.meti.interpret.statement;

public class InlineAssignment implements Assignment {
    private final Variable variable;
    private final Statement value;

    public InlineAssignment(Variable variable, Statement value) {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public Variable variable() {
        return variable;
    }

    @Override
    public String toString() {
        return "InlineAssignment{" +
                "variable=" + variable +
                ", value=" + value +
                '}';
    }

    @Override
    public Statement value() {
        return value;
    }
}
