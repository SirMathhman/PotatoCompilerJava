package com.meti.compile;

import com.meti.interpret.Invocation;
import com.meti.interpret.Statement;

import java.util.Collections;
import java.util.stream.Collectors;

class JSInvocationUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof Invocation;
	}

	@Override
	public String compile(Statement statement, CompilerState state, Compiler compiler) {
		var invocation = (Invocation) statement;
		var alias = state.alias(invocation.type().value());
		var parameterString = invocation.getParameters()
				.stream()
				.map(Collections::singletonList)
				.map(compiler::compile)
				.collect(Collectors.joining(","));
		return alias + "(" + parameterString + ");";
	}
}
