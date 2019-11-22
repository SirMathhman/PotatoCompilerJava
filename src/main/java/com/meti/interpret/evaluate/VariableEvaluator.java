package com.meti.interpret.evaluate;

import com.meti.assemble.node.Node;
import com.meti.assemble.node.VariableNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.statement.VariableStatement;

public class VariableEvaluator implements Evaluator {
    @Override
    public boolean canEvaluate(Node node) {
        return node instanceof VariableNode;
    }

    @Override
    public Statement evaluate(Node node, Interpreter interpreter) {
        var variable = (VariableNode) node;
        var name = variable.name();
        return new VariableStatement(name);
    }
}
