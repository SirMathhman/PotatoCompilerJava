package com.meti.interpret;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.control.InlineReturnNode;
import com.meti.assemble.node.control.ReturnNode;

class ReturnLoader implements Loader {
    @Override
    public boolean canLoad(AssemblyNode node) {
        return node instanceof InlineReturnNode;
    }

    @Override
    public Statement load(AssemblyNode node, Interpreter interpreter) {
        var returnNode = (ReturnNode) node;
        return new ReturnStatement(interpreter.loadChild(returnNode.value()));
    }
}
