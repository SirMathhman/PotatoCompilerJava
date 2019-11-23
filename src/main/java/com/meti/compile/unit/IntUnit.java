package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.IntStatement;
import com.meti.interpret.statement.Statement;

public class IntUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof IntStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		return String.valueOf(((IntStatement) statement).value());
	}
}
