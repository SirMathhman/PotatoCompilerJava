package com.meti.interpret;

import com.meti.assemble.AssemblyNode;
import com.meti.assemble.VariableNode;

class VariableLoader implements Loader {
    @Override
    public boolean canLoad(AssemblyNode node) {
        return node instanceof VariableNode;
    }

    @Override
    public Statement load(AssemblyNode node, Interpreter interpreter) {
        var variable = (VariableNode) node;
        return new InlineVariable(variable.name());
    }
}
