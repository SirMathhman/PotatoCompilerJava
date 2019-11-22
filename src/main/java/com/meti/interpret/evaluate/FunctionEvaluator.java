package com.meti.interpret.evaluate;

import com.meti.assemble.node.FunctionNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.statement.FunctionStatement;
import com.meti.interpret.statement.Statement;

import java.util.Map;
import java.util.stream.Collectors;

public class FunctionEvaluator implements Evaluator {
	private final Map<String, Type> typeMap;

	public FunctionEvaluator(Map<String, Type> typeMap) {
		this.typeMap = typeMap;
	}

	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof FunctionNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var function = (FunctionNode) node;
		var parameters = function.parameters();
		var parameterMap = parameters.entrySet()
				.stream()
				.map(entry -> Map.entry(entry.getKey(), interpreter.resolve(entry.getValue())))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		typeMap.putAll(parameterMap);
		var content = interpreter.interpret(function.content());
		typeMap.keySet().removeAll(parameterMap.keySet());
		return new FunctionStatement(function.name(), parameterMap, content);
	}
}
