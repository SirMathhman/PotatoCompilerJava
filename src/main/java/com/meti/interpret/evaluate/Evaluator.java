package com.meti.interpret.evaluate;

import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Statement;

public interface Evaluator {
    boolean canEvaluate(Node node);

    Statement evaluate(Node node, Interpreter interpreter);
}
