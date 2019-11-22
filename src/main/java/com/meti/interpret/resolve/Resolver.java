package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.statement.Statement;

public interface Resolver {
	boolean canResolve(Statement statement);

	default boolean canResolve(String value) {
		return false;
	}

	Type resolve(Statement statement, Interpreter interpreter);

	default Type resolve(String statement, Interpreter interpreter) {
		throw new UnsupportedOperationException("Cannot resolve " + statement + " with " + interpreter);
	}
}
