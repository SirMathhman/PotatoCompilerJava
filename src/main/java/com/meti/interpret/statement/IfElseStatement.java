package com.meti.interpret.statement;

import java.util.function.Predicate;

public class IfElseStatement implements Statement {
    private final Statement condition;
    private Statement ifBlock;
    private Statement elseBlock;

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

    @Override
    public void replaceAll(Predicate<? super Statement> test, Statement replacement) {
        if(test.test(ifBlock)) ifBlock = replacement;
        if(test.test(elseBlock)) elseBlock = replacement;
    }
}
