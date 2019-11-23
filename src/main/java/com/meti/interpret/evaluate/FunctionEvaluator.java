package com.meti.interpret.evaluate;

import com.meti.assemble.node.FunctionNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.ObjectType;
import com.meti.interpret.Type;
import com.meti.interpret.statement.FunctionStatement;
import com.meti.interpret.statement.Statement;

import java.util.Map;
import java.util.stream.Collectors;

public class FunctionEvaluator implements Evaluator {
	private final Map<? super String, ? super Type> typeMap;

	public FunctionEvaluator(Map<? super String, ? super Type> typeMap) {
		this.typeMap = typeMap;
	}

	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof FunctionNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var function = (FunctionNode) node;
		var parameterMap = parameters(interpreter, function);
		var returnType = returnType(interpreter, function);
		typeMap.putAll(parameterMap);
		var content = interpreter.interpret(function.content());
		typeMap.keySet().removeAll(parameterMap.keySet());
		return new FunctionStatement(function.name(), parameterMap, returnType, content);
	}

	private Map<String, Type> parameters(Interpreter interpreter, FunctionNode function) {
		return function.parameters()
				.entrySet()
				.stream()
				.map(entry -> Map.entry(entry.getKey(), interpreter.resolve(entry.getValue())))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	private Type returnType(Interpreter interpreter, FunctionNode function) {
		var returnTypeOptional = function.returnType();
		return returnTypeOptional.isPresent() ?
				interpreter.resolve(returnTypeOptional.get()) :
				new ObjectType(function.name());
	}
}
