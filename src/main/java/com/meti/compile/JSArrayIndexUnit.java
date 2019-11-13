package com.meti.compile;

import com.meti.interpret.statement.ArrayIndex;
import com.meti.interpret.statement.Statement;

public class JSArrayIndexUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof ArrayIndex;
	}

	@Override
	public String compile(Statement statement, CompilerState state, Compiler compiler) {
		var arrayIndex = (ArrayIndex) statement;
		var content = compiler.compile(arrayIndex.content());
		var index = compiler.compile(arrayIndex.index());
		return content + "[" + index + "]";
	}
}
