package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.evaluate.StringStatement;
import com.meti.interpret.statement.Statement;

public class StringUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof StringStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var string = (StringStatement) statement;
		return "\"" + string.value() + "\"";
	}
}
