package com.meti.interpret;

import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.Node;

class IntEvaluator implements Evaluator {
    @Override
    public boolean canEvaluate(Node node) {
        return node instanceof IntNode;
    }

    @Override
    public Statement evaluate(Node node, Interpreter interpreter) {
        return new IntStatement(((IntNode) node).value());
    }
}
