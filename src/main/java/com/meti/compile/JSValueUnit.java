package com.meti.compile;

import com.meti.assemble.StringNode;
import com.meti.interpret.Statement;
import com.meti.interpret.StringValue;

class JSValueUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof StringValue;
	}

	@Override
	public String compile(Statement statement, CompilerState state, Compiler compiler) {
		var string = (StringValue) statement;
		return "\"" + string.value() + "\"";
	}
}
