package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.control.InlineReturnNode;
import com.meti.assemble.node.control.ReturnNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.ReturnStatement;
import com.meti.interpret.statement.Statement;

public class ReturnLoader implements Loader {
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
