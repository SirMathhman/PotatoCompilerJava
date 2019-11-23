package com.meti.interpret.evaluate;

import com.meti.assemble.node.Node;
import com.meti.assemble.node.ReturnNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.ReturnStatement;
import com.meti.interpret.statement.Statement;

public class ReturnEvaluator implements Evaluator{
	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof ReturnNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var returnNode = (ReturnNode) node;
		var value = interpreter.interpret(returnNode.value());
		return new ReturnStatement(value);
	}
}
