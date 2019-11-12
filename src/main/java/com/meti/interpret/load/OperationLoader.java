package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.OperationNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Operation;
import com.meti.interpret.statement.Statement;

public class OperationLoader implements Loader {
    @Override
    public boolean canLoad(AssemblyNode node) {
        return node instanceof OperationNode;
    }

    @Override
    public Statement load(AssemblyNode node, Interpreter interpreter) {
        var operation = (OperationNode) node;
        var before = interpreter.loadChild(operation.before());
        var after = interpreter.loadChild(operation.after());
        return new Operation(operation.operator(), before, after);
    }
}
