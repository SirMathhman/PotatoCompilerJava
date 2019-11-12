package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.InlineVariableNode;
import com.meti.assemble.node.VariableNode;
import com.meti.interpret.statement.InlineVariable;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Statement;

public class VariableLoader implements Loader {
    @Override
    public boolean canLoad(AssemblyNode node) {
        return node instanceof InlineVariableNode;
    }

    @Override
    public Statement load(AssemblyNode node, Interpreter interpreter) {
        var variable = (VariableNode) node;
        return new InlineVariable(variable.name());
    }
}
