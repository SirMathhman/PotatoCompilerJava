package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.control.IfElseNode;
import com.meti.assemble.node.control.InlineIfElseNode;
import com.meti.interpret.statement.IfElseStatement;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Statement;

public class IfElseLoader implements Loader {
    @Override
    public boolean canLoad(AssemblyNode node) {
        return node instanceof InlineIfElseNode;
    }

    @Override
    public Statement load(AssemblyNode node, Interpreter interpreter) {
        var ifElse = (IfElseNode) node;
        return new IfElseStatement(interpreter.loadChild(ifElse.condition()),
                interpreter.loadChild(ifElse.ifBlock()),
                interpreter.loadChild(ifElse.elseBlock()));
    }
}
