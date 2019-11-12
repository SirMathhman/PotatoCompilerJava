package com.meti.interpret.resolve;

import com.meti.assemble.node.value.ValueNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.statement.StringValue;
import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

public class StringResolver implements Resolver {
	@Override
    public boolean canResolve(Statement statement) {
		return statement instanceof StringValue;
	}

	@Override
	public Type resolve(Statement statement, Interpreter interpreter) {
		return PrimitiveType.STRING;
	}
}
