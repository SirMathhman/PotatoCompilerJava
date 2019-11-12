package com.meti.interpret;

public class IfElseStatement implements Statement {
    private final Statement condition;
    private final Statement ifBlock;
    private final Statement elseBlock;

    public IfElseStatement(Statement condition, Statement ifBlock, Statement elseBlock) {
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    public Statement condition() {
        return condition;
    }

    public Statement ifBlock() {
        return ifBlock;
    }

    public Statement elseBlock() {
        return elseBlock;
    }
}
