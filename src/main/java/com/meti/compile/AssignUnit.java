package com.meti.compile;

import com.meti.interpret.statement.AssignStatement;
import com.meti.interpret.statement.Statement;

public class AssignUnit implements Unit {
	@Override
	public boolean canCompile(Statement value) {
		return value instanceof AssignStatement;
	}

	@Override
	public String compile(Statement value, Compiler compiler) {
		var assign = (AssignStatement) value;
		var name = assign.variable().name();
		return compiler.generator().alias(name) + "=" +
				compiler.compile(assign.value()) + ";";
	}
}
