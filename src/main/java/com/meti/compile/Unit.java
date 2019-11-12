package com.meti.compile;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.interpret.Statement;

public interface Unit {
	boolean canCompile(Statement statement);

	String compile(Statement statement, CompilerState state, Compiler compiler);
}
