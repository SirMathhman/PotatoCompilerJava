package com.meti.interpret.evaluate;

import com.meti.assemble.node.Node;
import com.meti.assemble.node.OperationNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.OperationStatement;
import com.meti.interpret.statement.Statement;

public class OperationEvaluator implements Evaluator {
	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof OperationNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var operation = (OperationNode) node;
		var s0 = interpreter.interpret(operation.node0());
		var s1 = interpreter.interpret(operation.node1());
		return new OperationStatement(s0, operation.operator(), s1);
	}
}
