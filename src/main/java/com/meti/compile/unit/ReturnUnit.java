package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.ReturnStatement;
import com.meti.interpret.statement.Statement;

public class ReturnUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof ReturnStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var returnStatement = (ReturnStatement) statement;
		var value = returnStatement.value();
		return "return " + compiler.compile(value) + ";";
	}
}
