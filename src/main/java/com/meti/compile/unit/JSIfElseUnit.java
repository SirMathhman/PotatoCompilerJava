package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.compile.Unit;
import com.meti.interpret.statement.IfElseStatement;
import com.meti.interpret.statement.Statement;

public class JSIfElseUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof IfElseStatement;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        var ifElse = (IfElseStatement) statement;
        var condition = compiler.compile(ifElse.condition());
        var ifBlock = compiler.compile(ifElse.ifBlock());
        var elseBlock = compiler.compile(ifElse.elseBlock());
        return "if(" + condition + "){" + ifBlock + "}else{" + elseBlock + "}";
    }
}
