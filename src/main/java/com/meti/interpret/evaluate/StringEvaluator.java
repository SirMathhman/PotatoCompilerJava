package com.meti.interpret.evaluate;

import com.meti.assemble.node.Node;
import com.meti.assemble.node.StringNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Statement;

public class StringEvaluator implements Evaluator{
	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof StringNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var string = (StringNode) node;
		return new StringStatement(string.value());
	}
}
