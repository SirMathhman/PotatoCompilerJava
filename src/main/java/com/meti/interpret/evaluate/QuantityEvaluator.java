package com.meti.interpret.evaluate;

import com.meti.assemble.node.Node;
import com.meti.assemble.node.QuantityNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.QuantityStatement;
import com.meti.interpret.statement.Statement;

public class QuantityEvaluator implements Evaluator {
	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof QuantityNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var quantity = (QuantityNode) node;
		var child = quantity.child();
		return new QuantityStatement(interpreter.interpret(child));
	}
}
