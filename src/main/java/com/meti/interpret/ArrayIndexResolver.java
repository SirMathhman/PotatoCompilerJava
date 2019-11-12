package com.meti.interpret;

import com.meti.interpret.resolve.Resolver;
import com.meti.interpret.statement.ArrayIndex;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.ArrayType;
import com.meti.interpret.type.Type;

public class ArrayIndexResolver implements Resolver {
	@Override
	public boolean canResolve(Statement statement) {
		return statement instanceof ArrayIndex;
	}

	@Override
	public Type resolve(Statement statement, Interpreter interpreter) {
		var arrayIndex = (ArrayIndex) statement;
		var content = arrayIndex.content();
		var contentType = interpreter.resolve(content);
		if(!contentType.getClass().equals(ArrayType.class)) {
			throw new IllegalArgumentException("Expected content type of \""
			 + contentType + "\" to be a type of array.");
		}
		var arrayType = (ArrayType) contentType;
		return arrayType.child();
	}
}
