package com.meti.interpret.statement;

import com.meti.interpret.type.Type;

import java.util.List;

public interface Invocation extends Statement {
	Type type();

	List<Statement> getParameters();
}
