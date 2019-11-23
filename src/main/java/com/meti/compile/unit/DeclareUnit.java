package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.DeclareStatement;
import com.meti.interpret.statement.Statement;

public class DeclareUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof DeclareStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var declare = (DeclareStatement) statement;
		var name = declare.variable().name();
		return "var " + compiler.generator().alias(name) + ";";
	}
}
