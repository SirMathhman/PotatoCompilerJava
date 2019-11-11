package com.meti.interpret;

class IfStatement implements Statement {
    private final Statement condition;
    private final Statement ifBlock;
    private final Statement elseBlock;

    public IfStatement(Statement condition, Statement ifBlock, Statement elseBlock) {
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    public Statement getCondition() {
        return condition;
    }

    public Statement getIfBlock() {
        return ifBlock;
    }

    public Statement getElseBlock() {
        return elseBlock;
    }
}
