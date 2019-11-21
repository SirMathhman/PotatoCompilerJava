package com.meti.compile;

import com.meti.interpret.statement.Statement;

public interface Compiler {
	String compile(Statement statement);

	Generator generator();
}
