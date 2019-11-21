package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.statement.OperationStatement;
import com.meti.interpret.statement.Statement;

public class OperationResolver implements Resolver {
	@Override
	public boolean canResolve(Statement statement) {
		return statement instanceof OperationStatement;
	}

	@Override
	public Type resolve(Statement statement, Interpreter interpreter) {
		var operation = (OperationStatement) statement;
		var s0 = operation.s0();
		var s1 = operation.s1();
		var type0 = interpreter.resolve(s0);
		var type1 = interpreter.resolve(s1);
		if (!(type0.equals(type1))) {
			throw new IllegalStateException(type0 + " and " + type1 + " are not equal to each other.");
		}
		return type0;
	}
}
