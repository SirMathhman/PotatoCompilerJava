package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.AssignStatement;
import com.meti.interpret.statement.Statement;

public class AssignUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof AssignStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var assign = (AssignStatement) statement;
		var name = assign.variable().name();
		return compiler.generator().alias(name) + "=" +
				compiler.compile(assign.value()) + ";";
	}
}
