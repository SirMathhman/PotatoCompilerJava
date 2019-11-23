package com.meti.interpret.evaluate;

import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.IntStatement;
import com.meti.interpret.statement.Statement;

public class IntEvaluator implements Evaluator {
    @Override
    public boolean canEvaluate(Node node) {
        return node instanceof IntNode;
    }

    @Override
    public Statement evaluate(Node node, Interpreter interpreter) {
        return new IntStatement(((IntNode) node).value());
    }
}
