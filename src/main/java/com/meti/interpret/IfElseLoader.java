package com.meti.interpret;

import com.meti.assemble.AssemblyNode;
import com.meti.assemble.IfElseNode;

class IfElseLoader implements Loader {
    @Override
    public boolean canLoad(AssemblyNode node) {
        return node instanceof IfElseNode;
    }

    @Override
    public Statement load(AssemblyNode node, Interpreter interpreter) {
        var ifElse = (IfElseNode) node;
        return new IfElseStatement(interpreter.loadChild(ifElse.condition()),
                interpreter.loadChild(ifElse.ifBlock()),
                interpreter.loadChild(ifElse.elseBlock()));
    }
}
