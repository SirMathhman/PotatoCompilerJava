package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.AllocStatement;
import com.meti.interpret.statement.Statement;

public class AllocUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof AllocStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var alloc = (AllocStatement) statement;
		var sizeString = compiler.compile(alloc.size());
		return "new Array(" + sizeString + ")";
	}
}
