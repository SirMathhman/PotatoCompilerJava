package com.meti.interpret.evaluate;

import com.meti.assemble.node.FunctionNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.FunctionStatement;
import com.meti.interpret.statement.Statement;

public class FunctionEvaluator implements Evaluator {
	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof FunctionNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var function = (FunctionNode) node;
		//TODO: add variables from parameters
		var content = interpreter.interpret(function.content());
		//then remove parameters
		return new FunctionStatement(function.name(), content);
	}
}
