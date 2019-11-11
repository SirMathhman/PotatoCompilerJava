package com.meti.compile;

import com.meti.interpret.Statement;

import java.util.List;

public interface Compiler {
	String compile(List<? extends Statement> statements);
}
