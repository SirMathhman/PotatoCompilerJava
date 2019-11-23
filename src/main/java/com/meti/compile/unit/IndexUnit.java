package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.IndexStatement;
import com.meti.interpret.statement.Statement;

public class IndexUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof IndexStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var arrayIndex = (IndexStatement) statement;
		var name = compiler.compile(arrayIndex.name());
		var index = compiler.compile(arrayIndex.index());
		return name + "[" + index + "]";
	}
}
