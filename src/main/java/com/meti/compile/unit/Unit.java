package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.Statement;

public interface Unit {
	boolean canCompile(Statement statement);

	String compile(Statement statement, Compiler compiler);
}
