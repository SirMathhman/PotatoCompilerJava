package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.control.FunctionNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.InlineFunction;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.Type;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionLoader implements Loader {
	@Override
	public boolean canLoad(AssemblyNode node) {
		return node instanceof FunctionNode;
	}

	@Override
	public Statement load(AssemblyNode node, Interpreter interpreter) {
		var functionNode = (FunctionNode) node;
		interpreter.addGenerics(functionNode.generics());
		var parameterMap = functionNode.parameters();
		var parameters = parameterMap.keySet()
				.stream()
				.collect(Collectors.toMap(Function.identity(), s -> findType(interpreter, parameterMap.get(s)
				)));
		Type returnType = null;
		var returnOptional = functionNode.returnType();
		if (returnOptional.isPresent()) {
			returnType = findType(interpreter, returnOptional.get());
		}
		var content = new ArrayList<Statement>();
		var subFunctions = new ArrayList<com.meti.interpret.statement.Function>();
		for (AssemblyNode assemblyNode : functionNode.getContent()) {
			if (assemblyNode instanceof FunctionNode) {
				var subFunction = (com.meti.interpret.statement.Function) interpreter.loadChild(assemblyNode);
				subFunctions.add(subFunction);
			} else {
				content.add(interpreter.loadChild(assemblyNode));
			}
		}

		interpreter.removeGenerics(functionNode.generics());
		return new InlineFunction(functionNode.name(),
				functionNode.keywords(),
				parameters,
				returnType,
				content,
				subFunctions);
	}

	private Type findType(Interpreter interpreter, String value) {
		var typeOptional = interpreter.find(value);
		if (typeOptional.isPresent()) {
			return typeOptional.get();
		} else if (interpreter.generics().contains(value)) {
			return new GenericType(value);
		} else {
			throw new IllegalArgumentException("Could not resolve type: " + value);
		}
	}
}
