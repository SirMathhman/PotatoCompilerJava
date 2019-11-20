package com.meti.interpret;

import com.meti.assemble.node.Node;

interface Evaluator {
    boolean canEvaluate(Node node);

    Statement evaluate(Node node, Interpreter interpreter);
}
