package com.meti.compile;

import com.meti.interpret.statement.IntStatement;
import com.meti.interpret.statement.Statement;

public class IntUnit implements Unit {
	@Override
	public boolean canCompile(Statement value) {
		return value instanceof IntStatement;
	}

	@Override
	public String compile(Statement value, Compiler compiler) {
		return String.valueOf(((IntStatement) value).value());
	}
}
