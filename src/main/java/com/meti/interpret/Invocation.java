package com.meti.interpret;

import java.util.List;

public interface Invocation extends Statement {
	Type type();

	List<Statement> getParameters();
}
