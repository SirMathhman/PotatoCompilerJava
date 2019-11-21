package com.meti.interpret.evaluate;

import com.meti.assemble.node.AllocNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.AllocStatement;
import com.meti.interpret.statement.Statement;

public class AllocEvaluator implements Evaluator {
	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof AllocNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var alloc = (AllocNode) node;
		var size = alloc.size();
		return new AllocStatement(interpreter.interpret(size));
	}
}
