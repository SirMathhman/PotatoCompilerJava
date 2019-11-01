package com.meti.compile;

import com.meti.CompileException;
import com.meti.assemble.AssemblyNode;
import com.meti.assemble.InvocationNode;
import com.meti.assemble.Type;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class InvocationPattern implements Pattern {
	@Override
	public boolean canCompile(AssemblyNode node) {
		return node instanceof InvocationNode;
	}

	@Override
	public String compile(AssemblyNode node, Compiler compiler) {
		var invocation = (InvocationNode) node;
		var name = invocation.methodName();
		var function = compiler.get(name).orElseThrow(() -> throwNoSuchMethod(name));
		var funcName = function.name();
		return funcName + "(" + format(invocation.parameters()) + ");";
	}

	private RuntimeException throwNoSuchMethod(List<String> name) {
		return new CompileException("No such method name: " + String.join(".",
				name));
	}

	private String format(Map<String, ? extends Type> parameters) {
		return parameters.keySet().stream()
				.map(s -> parameters.get(s).format(s))
				.collect(Collectors.joining());
	}
}
