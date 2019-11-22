package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.FunctionStatement;
import com.meti.interpret.statement.Statement;

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
		return "function " + name + "()" + content;
	}
}
