package com.meti.interpret;

import com.meti.assemble.AssemblyNode;
import com.meti.assemble.ReturnNode;

class ReturnLoader implements Loader {
    @Override
    public boolean canLoad(AssemblyNode node) {
        return node instanceof ReturnNode;
    }

    @Override
    public Statement load(AssemblyNode node, Interpreter interpreter) {
        var returnNode = (ReturnNode) node;
        return new ReturnStatement(interpreter.loadChild(returnNode.value()));
    }
}
