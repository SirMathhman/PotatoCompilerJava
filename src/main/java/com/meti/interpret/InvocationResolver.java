package com.meti.interpret;

import com.meti.interpret.resolve.Resolver;
import com.meti.interpret.statement.Invocation;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.Type;

public class InvocationResolver implements Resolver {
	@Override
	public boolean canResolve(Statement statement) {
		return statement instanceof Invocation;
	}

	@Override
	public Type resolve(Statement statement, Interpreter interpreter) {
		var invocation = (Invocation) statement;
		return invocation.type();
	}
}
