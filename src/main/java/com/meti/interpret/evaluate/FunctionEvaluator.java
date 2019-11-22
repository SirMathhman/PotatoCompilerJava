package com.meti.interpret.evaluate;

import com.meti.assemble.node.FunctionNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.statement.FunctionStatement;
import com.meti.interpret.statement.Statement;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionEvaluator implements Evaluator {
	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof FunctionNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var function = (FunctionNode) node;
		var parameterMap = function.parameters().entrySet()
				.stream()
				.map(entry -> Map.entry(entry.getKey(), interpreter.resolve(entry.getValue())))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		var content = interpreter.interpret(function.content());
		//then remove parameters
		return new FunctionStatement(function.name(), parameterMap, content);
	}
}
