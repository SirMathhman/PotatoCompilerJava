package com.meti.compile;

import com.meti.interpret.statement.Statement;

public interface Unit {
	boolean canCompile(Statement value);

	String compile(Statement value, Compiler compiler);
}
