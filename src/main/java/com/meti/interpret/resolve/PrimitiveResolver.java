package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.Primitive;
import com.meti.interpret.Type;
import com.meti.interpret.statement.PrimitiveStatement;
import com.meti.interpret.statement.Statement;

import java.util.Map;

public class PrimitiveResolver implements Resolver {
	private final Map<String, Type> primitives = Map.of(
			"string", Primitive.STRING
	);

	@Override
	public boolean canResolve(Statement statement) {
		return statement instanceof PrimitiveStatement;
	}

	@Override
	public boolean canResolve(String value) {
		return primitives.containsKey(value);
	}

	@Override
	public Type resolve(Statement statement, Interpreter interpreter) {
		return ((PrimitiveStatement) statement).type();
	}

	@Override
	public Type resolve(String statement, Interpreter interpreter) {
		return primitives.get(statement);
	}
}
