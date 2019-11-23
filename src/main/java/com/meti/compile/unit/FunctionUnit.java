package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.FunctionStatement;
import com.meti.interpret.statement.Statement;

import java.util.stream.Collectors;

public class FunctionUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof FunctionStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var function = (FunctionStatement) statement;
		var name = compiler.generator().alias(function.name());
		var content = compiler.compile(function.content());
		var parameters = function.parameters();
		var paramString = parameters.keySet()
				.stream()
				.map(compiler.generator()::alias)
				.collect(Collectors.joining(","));
		return "function " + name + "(" + paramString + ")" + content;
	}
}
