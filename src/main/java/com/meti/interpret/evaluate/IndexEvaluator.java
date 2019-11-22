package com.meti.interpret.evaluate;

import com.meti.assemble.node.IndexNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.IndexStatement;
import com.meti.interpret.statement.Statement;

public class IndexEvaluator implements Evaluator {
	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof IndexNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var indexNode = (IndexNode) node;
		var name = interpreter.interpret(indexNode.name());
		var index = interpreter.interpret(indexNode.index());
		return new IndexStatement(name, index);
	}
}
