package com.meti.compile;

import com.meti.interpret.statement.DeclareStatement;
import com.meti.interpret.statement.Statement;

public class DeclareUnit implements Unit {
	@Override
	public boolean canCompile(Statement value) {
		return value instanceof DeclareStatement;
	}

	@Override
	public String compile(Statement value, Compiler compiler) {
		var declare = (DeclareStatement) value;
		var name = declare.variable().name();
		return "var " + compiler.generator().alias(name) + ";";
	}
}
