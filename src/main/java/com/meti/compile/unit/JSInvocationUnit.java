package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.compile.Unit;
import com.meti.interpret.statement.Invocation;
import com.meti.interpret.statement.Statement;

import java.util.Collections;
import java.util.stream.Collectors;

public class JSInvocationUnit implements Unit {
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
		return alias + "(" + parameterString + ")";
	}
}
